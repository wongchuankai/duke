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

        boolean flag = true;
        while (flag) {
            String command = scan.nextLine();
            if(command.equals("bye")) {
                flag = false;
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!\n");
                System.out.println("____________________________________________________________");
            }
            else {
                System.out.println("____________________________________________________________");
                System.out.println(command+"\n");
                System.out.println("____________________________________________________________");
                System.out.println();
            }
        }

    }
}
