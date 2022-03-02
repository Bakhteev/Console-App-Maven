package View.ConsoleCommands;

public class AddIfMinCommand extends AbstractCommand {

    public AddIfMinCommand() {
        super("add_if_min", "add a new element to the collection if its value is less than the smallest " +
                "element in this collection.", "{element}");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
