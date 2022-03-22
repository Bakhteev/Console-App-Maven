import Controller.PersonAsker.PersonMaker;
import Controller.collectionManagers.LinkedListCollectionManager;
import Model.*;
import View.ConsoleClient.ConsoleClient;
import View.ConsoleCommands.*;
import utils.FileWorker;
import utils.JSONParser;

import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(args[0]);
        FileWorker fileWorker = new FileWorker(System.getProperty("user.dir") + "/../" + args[0]);
        JSONParser jsonParser = new JSONParser();
        LinkedListCollectionManager collectionManager = jsonParser.JSONParse(fileWorker.readFile(),
                LinkedListCollectionManager.class) == null ? new LinkedListCollectionManager() : jsonParser.JSONParse(fileWorker.readFile(), LinkedListCollectionManager.class);
        collectionManager.add(new Person("Tom", new Coordinates(10, 10), (long) 10000000, (float) 95.5,
                EyesColor.BLUE, HairsColor.BLACK, new Location(10L, 10, 100.F, "Moscow")));
        collectionManager.add(new Person("Tom", new Coordinates(10, 10), (long) 100, (float) 95.5,
                EyesColor.BLUE, HairsColor.BLACK, new Location(10L, 10, 100.F, "Moscow")));

        ConsoleClient consoleClient = new ConsoleClient();
        consoleClient.addCommands(new AbstractCommand[]{
                new HelpCommand(consoleClient),
                new InfoCommand(),
                new ShowCommand(collectionManager.getCollection()),
                new AddCommand(new PersonMaker(new Scanner(System.in)), collectionManager),
                new UpdateCommand(),
                new RemoveByIdCommand(collectionManager),
                new AddIfMinCommand(),
                new SaveCommand(fileWorker, jsonParser, collectionManager),
                new ExitCommand(),
                new ExecuteScriptCommand(),
                new ClearCommand(collectionManager),
                new RemoveGreaterCommand(),
                new PrintDescendingCommand(),
                new PrintUniqueLocationCommand(collectionManager),
                new CountByHeightCommand(collectionManager.getCollection()),
                new RemoveFirstCommand(collectionManager),
        });

//        consoleClient.help("help");

//        collectionManager.add(new PersonAsker(new Scanner(System.in)).startAsker());
//        for (Person p : collectionManager.getCollection()) {
//            System.out.println(p);
//        }
//        consoleClient.executeCommand("add");
//        consoleClient.executeCommand("show");
//        System.out.println(collectionManager.size());
//        consoleClient.executeCommand("remove_by_id" +" "+ collectionManager.getCollection().getFirst().getId());
//        consoleClient.executeCommand("show");
//        System.out.println(collectionManager.size());
//        System.out.println(collectionManager.getCollection().getFirst());
        consoleClient.executeCommand("show");
        consoleClient.executeCommand("save");

//        System.out.println(collectionManager.getCollection().getFirst());

    }


}



