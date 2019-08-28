public class ListCommand extends Command {

    public ListCommand(String command) {
        super(command);
     }

     @Override
     public void execute(TaskList task,Ui ui,Storage storage) throws DukeException {
         System.out.println("     Here are the tasks in your list:");
         for(int i = 0 ;i < task.getCount();i++) {
             int number = i + 1;
             System.out.println("     " + number + "." + task.getTaskList().get(i));
         }
     }
    
}