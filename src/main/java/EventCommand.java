import java.io.IOException;

public class EventCommand extends Command {
    private String command;

    public EventCommand(String command) {
        super(command);
        this.command = command;
    }

    @Override
    public void execute(TaskList task, Ui ui, Storage storage) throws DukeException {
        String[] eventtask = command.split("event ");
        String eventString = eventtask[1];
        String[] eventarr = eventString.split(" /at ");
        System.out.println("     Got it. I've added this task:");
        Event event = new Event(eventarr[0], eventarr[1]);
        task.addTask(event);
        int numberOfTask = task.getCount();
        System.out.println("       " + event.toString());
        System.out.println("     Now you have " + numberOfTask + " tasks in the list.");
        int checkdone = event.isDone ? 1 : 0;
        try {
            storage.appendToFile(checkdone + "/event/" + event.description + "/" + event.at+System.lineSeparator() );
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}