/**
 * Execute List command in Duke.
 */

public class ListCommand extends Command {

    /**
     *  List Command constructor using string user input.
     * @param command user String input
     */
    public ListCommand(String command) {
        super(command);
    }

    /**
     * Execute the List command.
     * @param task Tasklist data
     * @param ui Ui interfaces and strings
     * @param storage stored file
     */
    @Override
    public String execute(TaskList task, Ui ui, Storage storage) {
        String output = "";
        output += ("     Here are the tasks in your list:\n");
        for (int i = 0; i < task.getCount(); i++) {
            int number = i + 1;
            output += ("     " + number + "." + task.getTaskList().get(i) + "\n");
        }
        return output + "\n" + ui.showLine();
    }
    
}