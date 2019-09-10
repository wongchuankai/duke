import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public void deleteAll() {tasklist = new ArrayList<>(); }

    public String SortByDescription() {
        Collections.sort(getTaskList(),COMPARE_BY_DESCRIPTION);
        String desc = "";
        for(int i = 0; i < getTaskList().size(); i++) {
            desc += getTaskList().get(i).toString() +"\n";
        }
        return desc;
    }

    public String SortByType() {
        Collections.sort(getTaskList(),COMPARE_BY_TYPE);
        String desc = "";
        for(int i = 0; i < getTaskList().size(); i++) {
            desc += getTaskList().get(i).toString() +"\n";
        }
        return desc;
    }


    public Comparator<Task> COMPARE_BY_DESCRIPTION = new Comparator<Task>() {
        @Override
        public int compare(Task o1, Task o2) {
            return o1.getDescription().compareTo(o2.getDescription());
        }
    };

    public Comparator<Task> COMPARE_BY_TYPE = new Comparator<Task>() {
        @Override
        public int compare(Task o1, Task o2) {
            String TAG1;
            String TAG2;
            if (o1 instanceof ToDo) {
                TAG1 = "1";
            }
            else if (o1 instanceof  Event) {
                TAG1 = "2";
            } else {
                TAG1 = "3";
            }
            if (o2 instanceof ToDo) {
                TAG2 = "1";
            }
            else if (o2 instanceof  Event) {
                TAG2 = "2";
            } else {
                TAG2 = "3";
            }
            return TAG1.compareTo(TAG2);
        }
    };
}