import Controller.PersonMaker.PersonMaker;
import Controller.collectionManagers.LinkedListCollectionManager;
import Model.*;
import View.ConsoleClient.ConsoleClient;
import View.ConsoleCommands.*;
import utils.FileWorker;
import utils.JSONParser;

import java.io.Console;

public class Main {

    public static void main(String[] args) {
        FileWorker fileWorker = new FileWorker(args[0]);
        JSONParser jsonParser = new JSONParser();
        LinkedListCollectionManager collectionManager = new LinkedListCollectionManager();
        collectionManager.loadCollection((jsonParser.JSONParse(fileWorker.readFile(), Person[].class)));

        ConsoleClient consoleClient = new ConsoleClient();
        consoleClient.addCommands(new AbstractCommand[]{
                new HelpCommand(consoleClient),
                new InfoCommand(collectionManager),
                new ShowCommand(collectionManager.getCollection()),
                new AddCommand(collectionManager),
                new UpdateCommand(collectionManager),
                new RemoveByIdCommand(collectionManager),
                new AddIfMinCommand(collectionManager),
                new SaveCommand(fileWorker, jsonParser, collectionManager),
                new ExitCommand(),
                new ExecuteScriptCommand(consoleClient),
                new ClearCommand(collectionManager),
                new RemoveGreaterCommand(collectionManager),
                new PrintDescendingCommand(collectionManager.getCollection()),
                new PrintUniqueLocationCommand(collectionManager.getCollection()),
                new CountByHeightCommand(collectionManager.getCollection()),
                new RemoveFirstCommand(collectionManager),
        });
        consoleClient.startInteractiveMode();

//        Console console = System.console();
//        while(true){
//            String line = console.readLine("type smt\n");
//            System.out.println(line);
//        }
    }


}



