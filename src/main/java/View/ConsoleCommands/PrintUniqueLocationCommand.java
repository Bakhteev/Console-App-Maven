package View.ConsoleCommands;

public class PrintUniqueLocationCommand extends AbstractCommand{

    public PrintUniqueLocationCommand() {
        super("print_unique_location", "display the unique values of the location field of all " +
                "elements in the collection.", "");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
