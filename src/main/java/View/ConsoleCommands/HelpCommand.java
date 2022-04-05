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
            if (!argument.isEmpty())
                throw new IllegalArgumentException("Using of command: " + getName());
            consoleClient.getCommands().forEach((key, value) -> System.out.println(key + ": " + value.getDescription() + " " +
                    "Params: " + (value.getParameters().isEmpty() ? "none" : value.getParameters())));
            return true;
        } catch (IllegalArgumentException exception) {
            System.out.println("Использование: '" + getName() + "'");
        }
        return true;
    }


}
