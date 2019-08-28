import java.io.IOException;

public class DeleteCommand extends Command {
    String command;

    public DeleteCommand(String command) {
        super(command);
        this.command = command;
    }

    @Override
    public void execute(TaskList task,Ui ui,Storage storage) throws DukeException {
        String[] deletearr = command.split(" ");
        int number = Integer.parseInt(deletearr[1]) - 1;
        Task deletetask = task.getTaskList().get(number);
        System.out.println("     Noted. I've removed this task:");
        System.out.println("       " + deletetask.toString());
        task.deleteTask(number);
        System.out.println("     Now you have " + task.getCount() + " tasks in the list.");
        try {
            storage.DeleteWrite(number);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

}