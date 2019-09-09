import java.util.*;

/**
 * Text Ui of the application.
 */
public class Ui {

    private final Scanner input;
    
    /** UI interface divider lines* */
    private static final String DIVIDER_LINES = "    ____________________________________________________________";

    public Ui() {
        this.input = new Scanner(System.in);
    }

    /**
     * Generates and print the welcome message upon the start of the application.
     */

    public String showWelcome() {
        String logo = " ____        _        \n"
        + "|  _ \\ _   _| | _____ \n"
        + "| | | | | | | |/ / _ \\\n"
        + "| |_| | |_| |   <  __/\n"
        + "|____/ \\__,_|_|\\_\\___|\n";
        logo = ("Hello from\n" + logo);
        logo = ("Hello! I'm Duke");
        logo = ("What can I do for you?");
        return logo;
    }

    /**
     * Read user input
     * @return
     */
    public String readCommand() {
        String command = input.nextLine();
        return command;
    }

    /**
     * show the divider lines
     */
    public String showLine() {
        return (DIVIDER_LINES);
    }

    /**
     * show loading error
     */
    public String showLoadingError() {
        return ("Loading Error. New tasklist will be created");
    }

    /**
     * shows any error if there is thrown
     * @param message error message
     */
    public String showError(String message) {
        return (message);
    }

}