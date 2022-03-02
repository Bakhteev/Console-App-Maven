package View.ConsoleCommands;

public class RemoveGreaterCommand extends AbstractCommand {

    public RemoveGreaterCommand() {
        super("remove_greater", "remove from the collection all elements greater than the given.",
                "{element}");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
