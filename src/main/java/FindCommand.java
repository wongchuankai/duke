import java.io.IOException;
import java.util.ArrayList;

public class FindCommand extends Command{

    private String command;

    FindCommand(String command) {
        super(command);
        this.command = command;
    }

    @Override
    public void execute(TaskList task,Ui ui,Storage storage) throws DukeException {
        ArrayList<Task> tasklist = task.getTaskList();

        String[] strarr = command.split(" ");
        String search = strarr[1];
        System.out.println("     Here are the matching tasks in your list:");

        boolean none = true;

        for(int i = 0; i <tasklist.size();i++) {
            Task t = tasklist.get(i);
            boolean check = t.getDescription().contains(search);
            if(check) {
                none = false;
                System.out.println("     " + (i+1) + "." + t.toString());
            }
        }

        if (none) {
            System.out.println("     Cannot Find any matching task in the list.");
        }

    }

}
