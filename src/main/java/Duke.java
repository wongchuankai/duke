import java.util.*;

public class Duke {
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

        ArrayList<Task> taskArrayList = new ArrayList<>();

        boolean flag = true;
        while (flag) {
            String command = scan.nextLine();
            if(command.equals("bye")) {
                flag = false;
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
            }

            else if (command.equals("list")) {
                System.out.println("____________________________________________________________");
                for(int i = 0 ;i < taskArrayList.size();i++) {
                    int number = i + 1;
                    System.out.println(number + "." + taskArrayList.get(i).getStatusIcon() + " " + taskArrayList.get(i).description);
                }
                System.out.println("____________________________________________________________");

            }

            else {
                String[] strarr = command.split(" ");
                if (strarr[0].equals("done")) {
                    int number = Integer.parseInt(strarr[1]);
                    System.out.println("____________________________________________________________");
                    System.out.println(" Nice! I've marked this task as done:");
                    Task taskdone = taskArrayList.get(number);
                    taskdone.markAsDone();
                    System.out.println("   " + taskdone.getStatusIcon() + " " + taskdone.description);
                    System.out.println("____________________________________________________________");

                } else {
                    Task newTask = new Task(command);
                    taskArrayList.add(newTask);
                    System.out.println("____________________________________________________________");
                    System.out.println(" added: " + command);
                    System.out.println("____________________________________________________________");
                    System.out.println();
                }
            }
        }

    }
}
