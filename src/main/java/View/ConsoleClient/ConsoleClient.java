package View.ConsoleClient;

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
        String[] userCommand = command.split(" ", 2);
        return commands.get(userCommand[0]).execute(userCommand.length > 1 ? userCommand[1] : "");
    }

    public void printLn(String argument) {
        System.out.println(argument);
    }
}
