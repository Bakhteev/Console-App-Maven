package View.ConsoleCommands;

public class UpdateCommand extends AbstractCommand {

    public UpdateCommand() {
        super("update", "update the value of the collection element whose id is equal to the given one.",
                "id {element}");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
