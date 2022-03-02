package View.ConsoleCommands;

public class ClearCommand extends AbstractCommand{

    public ClearCommand(){
        super("clear", "clear collection", "");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
