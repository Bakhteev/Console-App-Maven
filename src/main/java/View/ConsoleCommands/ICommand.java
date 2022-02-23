package View.ConsoleCommands;

public interface ICommand {
    public String getName();
    public String getDescription();
    public boolean execute(String argument);
}
