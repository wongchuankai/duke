/**
 * Text Ui of the application.
 */
public class Ui {

    /** UI interface divider lines.**/
    private static final String DIVIDER_LINES = "    ____________________________________________";

    /**
     * Generates and print the welcome message upon the start of the application.
     */
    public String showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        logo += ("Hello! I'm Duke\n");
        logo += ("What can I do for you?\n");
        return logo;
    }

    /**
     * show the divider lines.
     */
    public String showLine() {
        return (DIVIDER_LINES);
    }

    /**
     * show loading error.
     */
    public String showLoadingError() {
        return ("Loading Error. New tasklist will be created");
    }

}