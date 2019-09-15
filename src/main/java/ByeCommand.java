/**
 * Exceute the bye command in Duke.
 */

public class ByeCommand extends Command {

    /**
     *  Bye Constructor with command string input.
     * @param command user string input
     */
    public ByeCommand(String command) {
        super(command);
    }

    /**
     * Execute the bye command.
     * @param task Tasklist data
     * @param ui Ui interfaces and strings
     * @param storage stored file
     */
    @Override
    public String execute(TaskList task, Ui ui, Storage storage) {
        return ("      Bye :) Hope to see you again soon!\n" + ui.showLine());
    }

    /**
     * Bye command means exit. return true.
     * @return return true
     */

    public boolean isExit() {
        return true;
    }


}