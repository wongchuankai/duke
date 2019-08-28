import java.util.*;
import java.io.*;

public class Storage {
    
    private String filePath;

    private Scanner scan;

    private File file;

    private ArrayList<Task> taskArrayList;

    public Storage(String filePath) {
        this.filePath = filePath;
        this.file = new File(this.filePath);
        taskArrayList = new ArrayList<>();
    }

    public ArrayList<Task> load() throws DukeException,IOException {
        scan = new Scanner(file);
        try {
        while (scan.hasNext()) {
            // example : 0/todo/homework
            // 1/deadline/homework/2nd of August 2019, 12.35pm
            String line = scan.nextLine();
            String[] scanned = line.split("/");
            if (scanned[1].equals("todo")) {
                ToDo scannedDo = new ToDo(scanned[2]);
                if (scanned[0].equals("1")) {
                    scannedDo.markAsDone();
                }
                taskArrayList.add(scannedDo);
            }
            else if (scanned[1].equals("event")) {
                Event scannedEvent = new Event(scanned[2],scanned[3]);
                if(scanned[0].equals("1")) {
                    scannedEvent.markAsDone();
                }
                taskArrayList.add(scannedEvent);
            }
            else if (scanned[1].equals("deadline")) {
                Deadline scannedDeadline = new Deadline(scanned[2],scanned[3]);
                if(scanned[0].equals("1")) {
                    scannedDeadline.markAsDone();
                }
                taskArrayList.add(scannedDeadline);
            }
        }
        return taskArrayList;
    }
    catch(Exception e) {
        throw new DukeException("LOADING ERROR");
    }
    }

    public void appendToFile(String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(filePath,true);
        fw.write(textToAppend);
        fw.close();
    }

    public void writeDone(int LineNumber, Task task) throws IOException {
        File filetobemodified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = new BufferedReader(new FileReader(filetobemodified));
        String line = reader.readLine();
        int number = 0;
        while (line != null) {
            if (number != LineNumber) {
                oldContent = oldContent + line + System.lineSeparator();
                number++;
                line = reader.readLine();
            } else {//replace first character with 1
                line = line.replaceFirst("0","1");
                oldContent = oldContent + line + System.lineSeparator();
                number++;
                line = reader.readLine();
            }
        }
        writeToFile(filePath,oldContent);
    }

    public void writeToFile(String filePath,String textToAdd)  throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

    public void DeleteWrite(int Linenumber) throws IOException {
        File filetobemodified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = new BufferedReader(new FileReader(filetobemodified));
        String line = reader.readLine();
        int number = 0;
        while (line != null) {
            if (number != Linenumber) {
                oldContent = oldContent + line + System.lineSeparator();
                number++;
                line = reader.readLine();
            } else {
                number++;
                line = reader.readLine();
            }
        }
        writeToFile(filePath,oldContent);
    }


}