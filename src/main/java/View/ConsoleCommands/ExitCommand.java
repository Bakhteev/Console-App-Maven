package View.ConsoleCommands;

public class ExitCommand extends AbstractCommand{

    public ExitCommand(){
        super("exit", "exit program without saving collection into file", "");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
