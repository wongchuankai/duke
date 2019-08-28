import java.io.IOException;

public class DoneCommand extends Command {
    String command;

    public DoneCommand(String command) {
        super(command);
        this.command = command;
    }

    @Override
    public void execute(TaskList task,Ui ui,Storage storage) throws DukeException {
        try {
            String[] donearr = command.split(" ");
            try {
                int x = Integer.parseInt(donearr[1]);
            } catch (NumberFormatException e) {
                throw new DukeException("Done _ must be a number");
            }
            if (donearr.length == 1) {
                throw new DukeException(" ☹ OOPS!!! Which task do you want to complete?");
            }

            int no = Integer.parseInt(donearr[1]) ;
            if(task.getCount() < no) {
                throw new DukeException("SSS");
            }
            else {
                Task donetask = task.getTaskList().get(no);

                System.out.println("     Nice! I've marked this task as done:");
                donetask.markAsDone();
                System.out.println("       " + donetask.toString());
                try {
                    storage.writeDone(no, donetask);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
        catch(IndexOutOfBoundsException e) {
            throw new DukeException("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }


    }

}