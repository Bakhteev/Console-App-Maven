import Controller.PersonMaker.PersonMaker;
import Controller.collectionManagers.LinkedListCollectionManager;
import Model.*;
import View.ConsoleClient.ConsoleClient;
import View.ConsoleCommands.*;
import utils.FileWorker;
import utils.JSONParser;

import java.io.Console;
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        FileWorker fileWorker = new FileWorker(System.getProperty("user.dir") + "/../" + args[0]);
        JSONParser jsonParser = new JSONParser();

        Person p1 = new Person("XUI", new Coordinates(10, 10), (long) 10000000, (float) 95.5, EyesColor.BLUE, HairsColor.BLACK, new Location(10L
                , 10, 100.F, "Moscow"));
        LinkedListCollectionManager collectionManager = new LinkedListCollectionManager();
        collectionManager.loadCollection((jsonParser.JSONParse(fileWorker.readFile(), Person[].class)));
//        collectionManager.add(p1);

        ConsoleClient consoleClient = new ConsoleClient();
        consoleClient.addCommands(new AbstractCommand[]{
                new HelpCommand(consoleClient),
                new InfoCommand(collectionManager),
                new ShowCommand(collectionManager.getCollection()),
                new AddCommand(new PersonMaker(new Scanner(System.in)), collectionManager),
                new UpdateCommand(collectionManager, new PersonMaker(new Scanner(System.in)), new Scanner(System.in)),
                new RemoveByIdCommand(collectionManager),
                new AddIfMinCommand(collectionManager, new PersonMaker(new Scanner(System.in))),
                new SaveCommand(fileWorker, jsonParser, collectionManager),
                new ExitCommand(),
                new ExecuteScriptCommand(),
                new ClearCommand(collectionManager),
                new RemoveGreaterCommand(new PersonMaker(new Scanner(System.in)), collectionManager),
                new PrintDescendingCommand(collectionManager.getCollection()),
                new PrintUniqueLocationCommand(collectionManager.getCollection()),
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
//        consoleClient.executeCommand("save");
//        consoleClient.executeCommand("show");
//        consoleClient.executeCommand("remove_greater");
//        consoleClient.executeCommand("show");
//        consoleClient.executeCommand("print_descending");
        consoleClient.executeCommand("show");

//        System.out.println(collectionManager.getCollection().getFirst());
//        while (true) {
//            Console console = System.console();
//            if (console != null) {
//                System.out.println("Hello u pidor");
//                consoleClient.executeCommand(console.readLine("type the command\n"));
//            }
//        }

//
//        consoleClient.executeCommand("update 770702072");


//        for (int i = 0; i < 100; i++){
//            System.out.println(i);
//            for (int j = 0 ; j < 101; j++){
//                System.out.println(j + "j");
//                if(j == 1) {
//                    System.out.println("break");
//                    break;
//                }
//            }
////            System.out.println("not breaked");
//        }
    }


}



