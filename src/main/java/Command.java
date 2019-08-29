/**
 * Execute the command in Duke.
 */
public class Command {
    private String command;

    /**
     *  Command constructor using string user input
     * @param command user String input
     */
    public Command (String command) {
        this.command = command;
    }


    /**
     *  Execute the command
     * @param task Tasklist data
     * @param ui Ui interfaces and strings
     * @param storage stored file
     * @throws DukeException if any of raw values are invalid
     */

    public void execute(TaskList task, Ui ui, Storage storage) throws DukeException {
    }
    
    public boolean isExit() {
        return false;
    }
}