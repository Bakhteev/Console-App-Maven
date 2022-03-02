package View.ConsoleCommands;

public class ExecuteScriptCommand extends AbstractCommand {

    public ExecuteScriptCommand() {
        super("execute_script", "read and execute script from file setup.", "file_name");
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
