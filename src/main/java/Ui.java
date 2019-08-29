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

    public void showWelcome() {
        String logo = " ____        _        \n"
        + "|  _ \\ _   _| | _____ \n"
        + "| | | | | | | |/ / _ \\\n"
        + "| |_| | |_| |   <  __/\n"
        + "|____/ \\__,_|_|\\_\\___|\n";
System.out.println("Hello from\n" + logo);
System.out.println("Hello! I'm Duke");
System.out.println("What can I do for you?");

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
    public void showLine() {
        System.out.println(DIVIDER_LINES);
    }

    /**
     * show loading error
     */
    public void showLoadingError() {
        System.out.println("Loading Error. New tasklist will be created");

    }

    /**
     * shows any error if there is thrown
     * @param message error message
     */
    public void showError(String message) {
        System.out.println(message);
    }

}