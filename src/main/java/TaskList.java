import java.util.ArrayList;

/**
 * Task List stores task information in an array list.
 */

public class TaskList {
    
    private ArrayList<Task> tasklist;

    public TaskList() {
        tasklist = new ArrayList<>();
    }

    /**
     * Get the task list.
     * @return
     */
    public ArrayList<Task> getTaskList() {
        return tasklist;
    }

    /**
     * constructor with task list from storage.
     * @param tasklist from storage class
     */
    public TaskList(ArrayList<Task> tasklist) {
        this.tasklist = tasklist;
    }

    /**
     * add task to the list.
     * @param task task
     */
    public void addTask(Task task) {
        tasklist.add(task);
    }


    public int getCount() {
        return tasklist.size();
    }

    /**
     * delete task in the list.
     * @param number task number
     */
    public void deleteTask(int number) {
        tasklist.remove(number);
    }

}