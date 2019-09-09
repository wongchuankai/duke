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

    public String execute(TaskList task, Ui ui, Storage storage) throws DukeException {
        return "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";
    }
    
    public boolean isExit() {
        return false;
    }
}