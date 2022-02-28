package View.ConsoleCommands;

public class RemoveByIdCommand extends AbstractCommand {

    public RemoveByIdCommand() {
        super("remove_by_id", "remove element from collection by its id.", "id");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
