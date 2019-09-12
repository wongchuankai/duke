import java.io.IOException;

/**
 * Execute the ToDo command in Duke.
 */

public class ToDoCommand extends Command {
    private String command;

    /**
     * ToDo constructor with string command.
     * @param command user string input
     */
    public ToDoCommand(String command) {
        super(command);
        this.command = command;
    }

    /**
     * Execute the ToDo command.
     * @param task Tasklist data
     * @param ui Ui interfaces and strings
     * @param storage stored file
     */
    @Override
    public String execute(TaskList task, Ui ui, Storage storage) {
        String output = "";
        String[] todotask = command.split("todo ");
        try {
            assert todotask.length > 0:" Must input todo task";
            if (todotask.length == 0) {
                throw new DukeException(" ☹ OOPS!!! The description of a todo cannot be empty.");
            }
            output = output + ("     Got it. I've added this task:\n");
            ToDo newToDoTask = new ToDo(todotask[1]);
            task.addTask(newToDoTask);
            int numberOfTask = task.getCount();
            output = output + ("        " + newToDoTask.toString()) + "\n";
            output = output + ("     Now you have " + numberOfTask + " tasks in the list.\n");
            int checkdone = newToDoTask.isDone ? 1 : 0;
            try {
                String textToAppend = checkdone + "/todo/" + newToDoTask.description + System.lineSeparator();
                storage.appendToFile(textToAppend);
            } catch (IOException e) {
                System.out.println(e);
            }
            return output;
        }catch (AssertionError e) {
            return e.toString();
        }catch (DukeException e) {
            return e.toString();
        }
    }

}