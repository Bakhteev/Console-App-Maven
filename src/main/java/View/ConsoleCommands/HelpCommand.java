package View.ConsoleCommands;

import View.ConsoleClient.ConsoleClient;

public class HelpCommand extends AbstractCommand {

    public HelpCommand() {
        super("help", "display help on available commands");
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new IllegalArgumentException();
            return true;
        } catch (IllegalArgumentException exception) {
            ConsoleClient.printLn("Использование: '" + getName() + "'");
        }
        return false;
    }
}
