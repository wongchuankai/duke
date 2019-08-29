import java.util.*;
import java.io.*;

/**
 * Entry point of Duke application.
 * Initialises the application and starts the interaction withthe user.
 */

public class Duke {

    /**
     * Initialises necessary classes and variables
     */
    private Storage storage;
    private TaskList tasks;
    private Ui ui;


    /**
     * Read the stored data in the file and executes it.
     * @param filePath filepath of stored data
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (IOException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     *  Runs the program until termination.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = new Parser().parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * Main method which runs the program
     * @param args
     */
    public static void main(String[] args) {
        new Duke("Tasklist.txt").run();
    }
}