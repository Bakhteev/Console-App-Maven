package View.ConsoleCommands;

public class PrintDescendingCommand extends AbstractCommand{

    public PrintDescendingCommand() {
        super("print_descending", "display the elements of the collection in descending order.", "");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
