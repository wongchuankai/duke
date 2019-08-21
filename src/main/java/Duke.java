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

        ArrayList<String> list = new ArrayList<>();

        boolean flag = true;
        while (flag) {
            String command = scan.nextLine();
            if(command.equals("bye")) {
                flag = false;
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!\n");
                System.out.println("____________________________________________________________");
            }

            else if (command.equals("list")) {
                System.out.println("____________________________________________________________");
                for(int i = 0 ;i < list.size();i++) {
                    System.out.println( (i + 1 )+". " + list.get(i));
                }
                System.out.println("____________________________________________________________");

            }

            else {
                list.add(command);

                System.out.println("____________________________________________________________");
                System.out.println(" added: " + command);
                System.out.println("____________________________________________________________");
                System.out.println();
            }
        }

    }
}
