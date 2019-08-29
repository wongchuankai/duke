import java.io.IOException;

/**
 * Execute the Delete command in Duke.
 */
public class DeleteCommand extends Command {
    String command;
    /**
     *  Delete Command constructor using string user input
     * @param command user String input
     */
    public DeleteCommand(String command) {
        super(command);
        this.command = command;
    }

    /**
     * Execute the Delete command
     * @param task Tasklist data
     * @param ui Ui interfaces and strings
     * @param storage stored file
     * @throws DukeException if any of raw values are invalid
     */
    @Override
    public void execute(TaskList task,Ui ui,Storage storage) throws DukeException {
        String[] deletearr = command.split(" ");
        int number = Integer.parseInt(deletearr[1]) - 1;
        Task deletetask = task.getTaskList().get(number);
        System.out.println("     Noted. I've removed this task:");
        System.out.println("       " + deletetask.toString());
        task.deleteTask(number);
        System.out.println("     Now you have " + task.getCount() + " tasks in the list.");
        try {
            storage.DeleteWrite(number);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

}