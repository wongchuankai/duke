import java.io.IOException;

/**
 * Execute Done command in Duke.
 */
public class DoneCommand extends Command {


    private String command;

    /**
     *  Done Command constructor using string user input.
     * @param command user String input
     */
    public DoneCommand(String command) {
        super(command);
        this.command = command;
    }

    /**
     * Execute the Done command.
     * @param task Tasklist data
     * @param ui Ui interfaces and strings
     * @param storage stored file
     * @throws DukeException if any of raw values are invalid
     */
    @Override
    public String execute(TaskList task, Ui ui, Storage storage) throws DukeException {
        String output = "";
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

            int no = Integer.parseInt(donearr[1]) - 1;
            if (task.getCount() < no) {
                throw new DukeException("SSS");
            } else {
                Task donetask = task.getTaskList().get(no);

                output += ("     Nice! I've marked this task as done: \n");
                donetask.markAsDone();
                output += ("       " + donetask.toString() + "\n");
                try {
                    storage.writeDone(no, donetask);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }

        return output;
    }

}