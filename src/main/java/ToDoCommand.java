import java.io.IOException;

/**
 * Execute the ToDo command in Duke.
 */

public class ToDoCommand extends Command {
    String command;

    /**
     * ToDo constructor with string command
     * @param command user string input
     */
    public ToDoCommand(String command) {
        super(command);
        this.command = command;
    }

    /**
     * Execute the ToDo command
     * @param task Tasklist data
     * @param ui Ui interfaces and strings
     * @param storage stored file
     * @throws DukeException if any of raw values are invalid
     */
    @Override
    public void execute(TaskList task,Ui ui,Storage storage) throws DukeException {
        String[] todotask = command.split("todo ");
        if (todotask.length == 1) {
            throw new DukeException(" ☹ OOPS!!! The description of a todo cannot be empty.");
        }
        System.out.println("     Got it. I've added this task:");
        ToDo newToDoTask = new ToDo(todotask[1]);
        task.addTask(newToDoTask);
        int numberOfTask = task.getCount();
        System.out.println("        " + newToDoTask.toString());
        System.out.println("     Now you have " + numberOfTask + " tasks in the list.");
         int checkdone = newToDoTask.isDone ? 1 : 0;
        try {
            String textToAppend = checkdone + "/todo/" + newToDoTask.description + System.lineSeparator();
            storage.appendToFile(textToAppend);
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

}