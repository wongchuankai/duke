public class Command {
    private String command;

    public Command (String command) {
        this.command = command;
    }

    public void execute(TaskList task,Ui ui,Storage storage) throws DukeException{

    }
    
    public boolean isExit() {
        return false;
    }
}