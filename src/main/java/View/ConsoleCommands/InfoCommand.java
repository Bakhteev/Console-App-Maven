package View.ConsoleCommands;

public class InfoCommand extends AbstractCommand{

    public InfoCommand(){
        super("info", "print information about the collection to standard output.", "");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
