package View.ConsoleCommands;

public interface ICommand {
    public String getName();

    public String getDescription();

    public String getParameters();

    public boolean execute(String argument);

    default public boolean execute() {
        return false;
    }
}
