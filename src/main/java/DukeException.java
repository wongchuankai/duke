/**
 * Signals an error caused by any data error in Duke program.
 */
public class DukeException extends Exception {

    public DukeException(String message) {
        super((message));
    }

}
