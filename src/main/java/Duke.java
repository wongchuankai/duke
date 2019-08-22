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
            try {
            if(command.equals("bye")) {
                flag = false;
                System.out.println("    ____________________________________________________________");
                System.out.println("      Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
            }

            else if (command.equals("list")) {
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
                        } catch (DukeException e) {
                            System.out.println(e);
                            System.out.println("    ____________________________________________________________");

                        }
                    }
                   else if (command.startsWith("deadline ")) {
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
                    }
                  else   if (command.startsWith("event ")){
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
                    }
                 else    if (command.startsWith("done ")) {
                        try {
                            String[] donearr = command.split(" ");
                            if (donearr.length == 1) {
                                throw new DukeException(" ☹ OOPS!!! Which task do you want to complete?");
                            }
                            if(donearr.length<Integer.parseInt(donearr[1])) {
                                throw new IndexOutOfBoundsException();
                            }
                            int no = Integer.parseInt(donearr[1]) - 1;
                            Task donetask = taskArrayList.get(no);

                            System.out.println("    ____________________________________________________________");
                            System.out.println("     Nice! I've marked this task as done:");

                            donetask.markAsDone();
                            System.out.println("       " + donetask.toString());

                            System.out.println("    ____________________________________________________________");
                        } catch (DukeException e) {
                            System.out.println(e);
                        }
                        catch (IndexOutOfBoundsException e) {
                            System.out.println(" ☹ OOPS!!! Task number not found.");
                        }

                    }
                 else if (command.startsWith("delete ")) {
                     String[] deletearr = command.split(" ");
                     int number = Integer.parseInt(deletearr[1]) - 1;
                     try {
                         Task deletetask = taskArrayList.get(number);
                         System.out.println("    ____________________________________________________________");
                         System.out.println("     Noted. I've removed this task:");
                         System.out.println("       " + deletetask.toString());
                         taskArrayList.remove(number);
                         System.out.println("     Now you have " + taskArrayList.size() + " tasks in the list.");
                         System.out.println("    ____________________________________________________________");
                     }
                     catch (IndexOutOfBoundsException e) {
                         System.out.println(" ☹ OOPS!!! Task number not found.");
                     }
                 }

                    else {
                System.out.println("    ____________________________________________________________");
                        throw new DukeException(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }
            catch (DukeException e) {
                System.out.println(e);
                System.out.println("    ____________________________________________________________");
            }
        }

    }
}
