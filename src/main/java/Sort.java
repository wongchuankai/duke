import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class Sort extends Command{

    String command;

    /**
     * Command constructor using string user input.
     *
     * @param command user String input
     */
    public Sort(String command) {
        super(command);
        this.command = command;
    }

    @Override
    public String execute(TaskList task, Ui ui, Storage storage) throws DukeException {
        String[] getSortingOrder = command.split(" ");
        if (getSortingOrder[1].equals("1") || getSortingOrder[1].equals("desc")) {
            String desc = "     Here are the tasks in your list:\n";
            task.SortByDescription();
            try {
                storage.WriteToStorage(task);
            } catch (IOException e) {
                return "ERROR";
            }
            for (int i = 1; i <= task.getCount(); i++) {
                desc += "     " + i + "." + task.getTaskList().get(i - 1) + "\n";
            }
            return desc;
        } else if (getSortingOrder[1].equals("2") || getSortingOrder[1].equals("type")) {
            String desc = "     Here are the tasks in your list:\n";
            task.SortByType();
            try {
                storage.WriteToStorage(task);
            } catch (IOException e) {
                return "ERROR";
            }
            for (int i = 1; i <= task.getCount(); i++) {
                desc += "     " + i + "." + task.getTaskList().get(i - 1) + "\n";
            }
            return desc;
        } else {
            return "     Please Input the correct command.\n     sort<SPACE>1/2 only\n     or sort<SPACE>desc/type only";
        }
    }
}
