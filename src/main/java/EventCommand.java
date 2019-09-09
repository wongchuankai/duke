import java.io.IOException;

/**
 * Execute Event command in Duke.
 */

public class EventCommand extends Command {
    private String command;

    /**
     *  Event Command constructor using string user input
     * @param command user String input
     */
    public EventCommand(String command) {
        super(command);
        this.command = command;
    }

    /**
     * Execute the Event command
     * @param task Tasklist data
     * @param ui Ui interfaces and strings
     * @param storage stored file
     * @throws DukeException if any of raw values are invalid
     */
    @Override
    public String execute(TaskList task, Ui ui, Storage storage) throws DukeException {
        String output = "";
        String[] eventtask = command.split("event ");
        String eventString = eventtask[1];
        String[] eventarr = eventString.split(" /at ");
        output += ("     Got it. I've added this task:\n");
        Event event = new Event(eventarr[0], eventarr[1]);
        task.addTask(event);
        int numberOfTask = task.getCount();
        output += ("       " + event.toString() + "\n");
        output += ("     Now you have " + numberOfTask + " tasks in the list.\n");
        int checkdone = event.isDone ? 1 : 0;
        try {
            storage.appendToFile(checkdone + "/event/" + event.description + "/" + event.at+System.lineSeparator() );
        } catch (IOException e) {
            System.out.println(e);
        }
        return output;
    }

}