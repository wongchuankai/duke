import java.io.IOException;

public class ToDoCommand extends Command {
    private String command;

    public ToDoCommand(String command) {
        super(command);
        this.command = command;
    }

    @Override
    public void execute(TaskList task, Ui ui, Storage storage) throws DukeException {
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
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}