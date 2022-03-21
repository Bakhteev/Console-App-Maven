package View.ConsoleCommands;

import View.ConsoleClient.ConsoleClient;

public class HelpCommand extends AbstractCommand {
    ConsoleClient consoleClient;

    public HelpCommand(ConsoleClient consoleClient) {
        super("help", "display help on available commands.", "");
        this.consoleClient = consoleClient;
    }

    @Override
    public boolean execute(String argument) {
        try {
            consoleClient.getCommands().forEach((key, value) -> consoleClient.printLn(key + ": " + value.getDescription() + " " +
                    "Params: " + (value.getParameters().isEmpty() ? "none" : value.getParameters())));
            return true;
        } catch (IllegalArgumentException exception) {
            consoleClient.printLn("Использование: '" + getName() + "'");
        }
        return false;
    }


}
