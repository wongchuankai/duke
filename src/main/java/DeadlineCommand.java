/**
 * Execute the Deadline command in Duke.
 */

import java.io.IOException;

public class DeadlineCommand extends Command {
    private String command;

    /**
     * Deadline constructor with string command.
     * @param command user string input
     */
    public DeadlineCommand(String command) {
        super(command);
        this.command = command;
    }

    /**
     * Execute the Deadline command.
     * @param task Tasklist data
     * @param ui Ui interfaces and strings
     * @param storage stored file
     * @throws DukeException if any of raw values are invalid
     */
    @Override
    public String execute(TaskList task, Ui ui, Storage storage) throws DukeException {
        String output = "";
        try {
            String[] deadlinetask = command.split("deadline ");
            String deadlineString = deadlinetask[1];
            String[] deadlinearr = deadlineString.split(" /by ");
            output += ("     Got it. I've added this task:\n");
            String[] date = deadlinearr[1].split("/");
            String[] tm = date[2].split(" ");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(tm[0]);
            String time = tm[1];
            Time t = new Time(day, month, year, time);
            Deadline deadline = new Deadline(deadlinearr[0], t.toString());
            task.addTask(deadline);
            assert deadline != null;
            int numberOfTask = task.getCount();
            output += ("       " + deadline.toString() + "\n");
            output += ("     Now you have " + numberOfTask + " tasks in the list.\n");
            int checkdone = deadline.isDone ? 1 : 0;
            try {
                String text = checkdone + "/deadline/" + deadline.description + "/" + deadline.by;
                storage.appendToFile(text + System.lineSeparator());
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("    ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
        return output;
    }

}