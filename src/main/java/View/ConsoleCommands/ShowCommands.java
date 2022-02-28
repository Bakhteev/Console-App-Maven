package View.ConsoleCommands;

public class ShowCommands extends AbstractCommand {
    public ShowCommands(){
        super("show", "print to standard output all elements of the collection in string representation.", "");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
