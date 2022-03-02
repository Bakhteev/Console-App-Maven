package View.ConsoleCommands;

public class ShowCommand extends AbstractCommand {
    public ShowCommand(){
        super("show", "print to standard output all elements of the collection in string representation.", "");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
