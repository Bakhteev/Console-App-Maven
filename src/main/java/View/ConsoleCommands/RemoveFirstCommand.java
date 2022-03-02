package View.ConsoleCommands;

public class RemoveFirstCommand extends AbstractCommand {

    public RemoveFirstCommand() {
        super("remove_first", "remove first element of collection", "");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
