package View.ConsoleCommands;

public interface ICommand {
    public String getName();

    public String getDescription();

    public String getParameters();

    default public boolean execute(String argument) {
        return false;
    }

    default public <T> boolean execute(T obj) {
        return false;
    }
}
