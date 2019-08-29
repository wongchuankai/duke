public class Parser {
    
    public Parser() {

    }
    public Command parse(String command) {
        if (command.startsWith("todo ")) {
            ToDoCommand c = new ToDoCommand(command);
            return c;
        } else if (command.startsWith("list")) {
            ListCommand c = new ListCommand(command);
            return c;
        } else if (command.startsWith("bye")) {
            ByeCommand c = new ByeCommand(command);
            return c;
        } else if (command.startsWith("deadline ")) {
            DeadlineCommand c = new DeadlineCommand(command);
            return c;
        } else if (command.startsWith("event ")) {
            EventCommand c = new EventCommand(command);
            return c;
        } else if (command.startsWith("done ")) {
            DoneCommand c = new DoneCommand(command);
            return c;
        } else if (command.startsWith("delete ")) {
            DeleteCommand c = new DeleteCommand(command);
            return c;
        }else if (command.startsWith("find ")) {
            FindCommand c = new FindCommand(command);
            return c;
        }
        else  {
            WrongCommand c = new WrongCommand(command);
            return c;
        }
    }

}