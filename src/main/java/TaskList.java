import java.util.ArrayList;


public class TaskList {
    
    private ArrayList<Task> tasklist;

    public TaskList() {
        tasklist = new ArrayList<>();
    } 

    public ArrayList<Task> getTaskList() {
        return tasklist;
    }

    public TaskList(ArrayList<Task> tasklist) {
        this.tasklist = tasklist;
    }

    public void addTask(Task task) {
        tasklist.add(task);
    }


    public int getCount() {
        return tasklist.size();
    }

    public void deleteTask(int number) {
        tasklist.remove(number);
    }

}