package View.ConsoleCommands;

public class CountByHeightCommand extends AbstractCommand {

    public CountByHeightCommand() {
        super("count_by_height", "display the number of elements whose height field value is equal to the " +
                "given one.", "height");
    }


    @Override
    public boolean execute(String argument) {
        return false;
    }
}
