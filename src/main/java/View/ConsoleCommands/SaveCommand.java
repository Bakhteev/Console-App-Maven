package View.ConsoleCommands;

public class SaveCommand extends AbstractCommand{

    public SaveCommand(){
        super("save", "saves collection data to file", "");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
