public class ByeCommand extends Command {

    public ByeCommand(String command) {
        super(command);
    }

    @Override
    public void execute(TaskList task,Ui ui,Storage storage) {
        System.out.println("      Bye. Hope to see you again soon!");
    }

    @Override 
    public boolean isExit() {
        return true;
    }


}