import java.util.*;
import java.io.*;

public class Duke {
    public static ArrayList<Task> taskArrayList = new ArrayList<>();

    public static void writeToFile(String filePath,String textToAdd)  throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(textToAdd);
        fw.close();
    }

    public static void appendToFile(String filePath,String textToAppend) throws IOException {

        FileWriter fw = new FileWriter(filePath,true);
        fw.write(textToAppend);
        fw.close();
    }

    public static void printFileContents(String filePath) throws FileNotFoundException,DukeException {
        File f = new File("Tasklist.txt");
         Scanner scan = new Scanner(f);
        while (scan.hasNext()) {

            String line = scan.nextLine();
           // System.out.println(line);
            //1 todo homework
            String[] scanned = line.split("/");
            if (scanned[1].equals("todo")) {
                ToDo scannedDo = new ToDo(scanned[2]);
                if(scanned[0].equals("1")) {
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
    }

    public static void Event(String command) {
        String[] eventtask = command.split("event ");
        String eventString = eventtask[1];
        String[] eventarr = eventString.split(" /at ");
        System.out.println("    ____________________________________________________________");
        System.out.println("     Got it. I've added this task:");
        Event event = new Event(eventarr[0], eventarr[1]);
        taskArrayList.add(event);
        int numberOfTask = taskArrayList.size();
        System.out.println("       " + event.toString());
        System.out.println("     Now you have " + numberOfTask + " tasks in the list.");
        System.out.println("    ____________________________________________________________");
        int checkdone = event.isDone ? 1 : 0;
        try {
            appendToFile("Tasklist.txt", System.lineSeparator() +checkdone + "/event/" + event.description + "/" + event.at);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void Deadline(String command) throws DukeException {
        String[] deadlinetask = command.split("deadline ");
        String deadlineString = deadlinetask[1];
        String[] deadlinearr = deadlineString.split(" /by ");
        System.out.println("    ____________________________________________________________");
        System.out.println("     Got it. I've added this task:");
        Deadline deadline = new Deadline(deadlinearr[0], deadlinearr[1]);
        taskArrayList.add(deadline);
        int numberOfTask = taskArrayList.size();
        System.out.println("       " + deadline.toString());
        System.out.println("     Now you have " + numberOfTask + " tasks in the list.");
        System.out.println("    ____________________________________________________________");
        int checkdone = deadline.isDone ? 1 : 0;
        try {
            appendToFile("Tasklist.txt", System.lineSeparator() +checkdone + "/deadline/" + deadline.description + "/" + deadline.by);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void Todo(String command) throws DukeException {
        System.out.println("    ____________________________________________________________");
        String[] todotask = command.split("todo ");
        if (todotask.length == 1) {
            throw new DukeException(" ☹ OOPS!!! The description of a todo cannot be empty.");
        }
         System.out.println("     Got it. I've added this task:");
        ToDo newToDoTask = new ToDo(todotask[1]);
        taskArrayList.add(newToDoTask);
        int numberOfTask = taskArrayList.size();
        System.out.println("        " + newToDoTask.toString());
        System.out.println("     Now you have " + numberOfTask + " tasks in the list.");
        System.out.println("    ____________________________________________________________");
        int checkdone = newToDoTask.isDone ? 1 : 0;
        try {
            appendToFile("Tasklist.txt", System.lineSeparator() +checkdone + "/todo/" + newToDoTask.description);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void Done(String command) throws DukeException {
        String[] donearr = command.split(" ");
        if (donearr.length == 1) {
            throw new DukeException(" ☹ OOPS!!! Which task do you want to complete?");
        }
        if(donearr.length<Integer.parseInt(donearr[1]) - 1) {
            throw new IndexOutOfBoundsException();
        }
        int no = Integer.parseInt(donearr[1]) - 1;
        Task donetask = taskArrayList.get(no);

        System.out.println("    ____________________________________________________________");
        System.out.println("     Nice! I've marked this task as done:");

        donetask.markAsDone();
        System.out.println("       " + donetask.toString());

        System.out.println("    ____________________________________________________________");

        try {
            writeDone(no,donetask);
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void writeDone(int LineNumber,Task task) throws IOException {
        File filetobemodified = new File("Tasklist.txt");
        String oldContent = "";
        BufferedReader reader = new BufferedReader(new FileReader(filetobemodified));
        String line = reader.readLine();
        int number = 0;
        while (line != null) {
            if (number != LineNumber) {
                oldContent = oldContent + line + System.lineSeparator();
                number++;
                line = reader.readLine();
            } else {
              //replace first character with 1
                line = line.replaceFirst("0","1");
                oldContent = oldContent + line + System.lineSeparator();
                number++;
                line = reader.readLine();
            }
        }
        writeToFile("Tasklist.txt",oldContent);
    }

    public static void Delete(String command) throws IOException,DukeException {
        String[] deletearr = command.split(" ");
        int number = Integer.parseInt(deletearr[1]) - 1;
        Task deletetask = taskArrayList.get(number);
        System.out.println("    ____________________________________________________________");
        System.out.println("     Noted. I've removed this task:");
        System.out.println("       " + deletetask.toString());
        taskArrayList.remove(number);
        System.out.println("     Now you have " + taskArrayList.size() + " tasks in the list.");
        System.out.println("    ____________________________________________________________");
        try {
            DeleteWrite(number);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
    public static void DeleteWrite(int Linenumber) throws IOException{
        File filetobemodified = new File("Tasklist.txt");
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
        writeToFile("Tasklist.txt",oldContent);
    }

    public static void Bye(String command) {
        System.out.println("    ____________________________________________________________");
        System.out.println("      Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
   
    }
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        Scanner scan = new Scanner (System.in);

        try {
            printFileContents("Tasklist.txt");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (DukeException e) {
            System.out.println(e);
        }

        boolean flag = true;
        while (flag) {
            String command = scan.nextLine();

           
            try {
            if(command.startsWith("bye")) {
                flag = false;
                Bye(command);
            }

            else if (command.startsWith("list")) {
                System.out.println("    ____________________________________________________________");
                System.out.println("     Here are the tasks in your list:");
                for(int i = 0 ;i < taskArrayList.size();i++) {
                    int number = i + 1;
                    System.out.println("     " + number + "." + taskArrayList.get(i));
                }
                System.out.println("    ____________________________________________________________");

            }

            else if (command.startsWith("todo")) {
                        try {
                        Todo(command);    
                        } catch (DukeException e) {
                            System.out.println("     ☹ OOPS!!! The description of a todo cannot be empty.");
                            System.out.println("    ____________________________________________________________");

                        }
                    }
                   else if (command.startsWith("deadline ")) {
                        Deadline(command);    
                }
                  else   if (command.startsWith("event ")){
                        Event(command);
                }
                 else    if (command.startsWith("done ")) {
                        try {
                           Done(command);
                        } catch (DukeException e) {
                            System.out.println(e);
                        }
                        catch (IndexOutOfBoundsException e) {
                            System.out.println("    ____________________________________________________________");
                            System.out.println("     ☹ OOPS!!! Task number not found.");
                            System.out.println("    ____________________________________________________________");
                        }

                    }
                 else if (command.startsWith("delete ")) {
                     try {
                         Delete(command);
                     }
                     catch (IOException e) {
                         System.out.println(e);
                     }

                     catch (IndexOutOfBoundsException e) {
                         System.out.println("    ____________________________________________________________");
                         System.out.println("     ☹ OOPS!!! Task number not found.");
                         System.out.println("    ____________________________________________________________");
                     }
                 }

                    else {
                        throw new DukeException(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }
            catch (DukeException e) {
                System.out.println("    ____________________________________________________________");
                System.out.println("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                System.out.println("    ____________________________________________________________");
            }
        }


    }
}