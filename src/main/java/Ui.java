import java.util.*;

public class Ui {

    private final Scanner input;
    
    /** */
    private static final String DIVIDER_LINES = "    ____________________________________________________________";

    public Ui() {
        this.input = new Scanner(System.in);
    }

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

    public String readCommand() {
        String command = input.nextLine();
        return command;
    }


    public void showLine() {
        System.out.println(DIVIDER_LINES);
    }

    public void showLoadingError() {
        System.out.println("Loading Error. New tasklist will be created");
    }

    public void showError(String message) {
        System.out.println(message);
    }

}