package View.ConsoleClient;

import Controller.collectionManagers.LinkedListCollectionManager;
import View.ConsoleCommands.AbstractCommand;

import java.util.Collection;
import java.util.LinkedHashMap;

public class ConsoleClient {

    LinkedHashMap<String, AbstractCommand> commands = new LinkedHashMap<>();


    public ConsoleClient(AbstractCommand[] commands) {
        for (AbstractCommand command : commands) {
            this.commands.put(command.getName(), command);
        }

    }

    static public void printLn(String argument) {
        System.out.println(argument);
    }

    public void help(String argument) {
        if (commands.containsKey(argument)) {
            if (commands.get(argument).execute("")) {
                commands.forEach((key, value) -> printLn(key + ": " + value.getDescription() + " Params: " + (value.getParameters().isEmpty() ? "none" : value.getParameters())));
            }
        }
    }
}
