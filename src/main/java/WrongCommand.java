import java.io.IOException;

public class WrongCommand extends Command {
    private String command;

    public WrongCommand(String command) {
        super(command);
        this.command = command;
    }

    @Override
    public void execute(TaskList task, Ui ui, Storage storage) throws DukeException {
       throw new DukeException("     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

}