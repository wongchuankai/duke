import java.io.IOException;

/**
 * Execute the Delete command in Duke.
 */
public class DeleteCommand extends Command {

    private String command;

    /**
     *  Delete Command constructor using string user input.
     * @param command user String input
     */
    public DeleteCommand(String command) {
        super(command);
        this.command = command;
    }

    /**
     * Execute the Delete command.
     * @param task Tasklist data
     * @param ui Ui interfaces and strings
     * @param storage stored file
     * @throws DukeException if any of raw values are invalid
     */
    @Override
    public String execute(TaskList task, Ui ui, Storage storage) throws DukeException {
        String output = "";
        String[] deletearr = command.split(" ");
        if (deletearr[1].equals("all")) {
            try {
                storage.deleteWrite(-1);
            } catch (IOException e) {
                return "ERROR";
            }
            output += "     Noted. I've removed all tasks.\n";
            output += "     Now you have 0 task in the list.\n";
            task.deleteAll();
            return output;
        } else {
            int number = Integer.parseInt(deletearr[1]) - 1;
            Task deletetask = task.getTaskList().get(number);
            output += ("     Noted. I've removed this task:\n");
            output += ("       " + deletetask.toString() + "\n");
            task.deleteTask(number);
            output += ("     Now you have " + task.getCount() + " tasks in the list.\n");
            try {
                storage.deleteWrite(number);
            } catch (IOException e) {
                System.out.println(e);
            }
            return output;
        }
    }

}