/**
 * Execute List command in Duke.
 */

public class ListCommand extends Command {

    /**
     *  List Command constructor using string user input
     * @param command user String input
     */
    public ListCommand(String command) {
        super(command);
     }

     /**
     * Execute the List command
     * @param task Tasklist data
     * @param ui Ui interfaces and strings
     * @param storage stored file
     * @throws DukeException if any of raw values are invalid
     */
     @Override
     public void execute(TaskList task,Ui ui,Storage storage) throws DukeException {
         System.out.println("     Here are the tasks in your list:");
         for(int i = 0 ;i < task.getCount();i++) {
             int number = i + 1;
             System.out.println("     " + number + "." + task.getTaskList().get(i));
         }
     }
    
}