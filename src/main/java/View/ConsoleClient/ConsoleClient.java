package View.ConsoleClient;

import Exeptions.NoSuchCommandException;
import View.ConsoleCommands.AbstractCommand;

import java.util.LinkedHashMap;

public class ConsoleClient {

    LinkedHashMap<String, AbstractCommand> commands = new LinkedHashMap<>();

    public void addCommands(AbstractCommand[] commands) {
        for (AbstractCommand command : commands) {
            this.commands.put(command.getName(), command);
        }
    }

    public LinkedHashMap<String, AbstractCommand> getCommands() {
        return commands;
    }

    public boolean executeCommand(String command) {
        try {
            String[] userCommand = command.split(" ", 2);
            if (!commands.containsKey(userCommand[0])) {
                throw new NoSuchCommandException("No such command " + userCommand[0]);
            }
            return commands.get(userCommand[0]).execute(userCommand.length > 1 ? userCommand[1] : "");
        } catch (NoSuchCommandException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void printLn(String argument) {
        System.out.println(argument);
    }
}
