import java.io.IOException;
import java.util.ArrayList;
/**
 * Execute the Find command in Duke.
 */

public class FindCommand extends Command {

    private String command;

    /**
     *  Find Command constructor using string user input.
     * @param command user String input
     */
    public FindCommand(String command) {
        super(command);
        this.command = command;
    }

    /**
     * Execute the Find command.
     * @param task Tasklist data
     * @param ui Ui interfaces and strings
     * @param storage stored file
     * @throws DukeException if any of raw values are invalid
     */
    @Override
    public String execute(TaskList task,Ui ui,Storage storage) throws DukeException {
        String output = "";
        ArrayList<Task> tasklist = task.getTaskList();

        String[] strarr = command.split(" ");
        String search = strarr[1];
        output += ("     Here are the matching tasks in your list:\n");

        boolean none = true;

        for (int i = 0; i < tasklist.size();i++) {
            Task t = tasklist.get(i);
            boolean check = t.getDescription().contains(search);
            if (check) {
                none = false;
                output += ("     " + (i + 1) + "." + t.toString() + "\n");
            }
        }

        if (none) {
            output += ("     Cannot Find any matching task in the list.\n");
        }

        return output;
    }

}
