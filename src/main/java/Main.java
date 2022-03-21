import Controller.PersonAsker.PersonAsker;
import Controller.collectionManagers.LinkedListCollectionManager;
import Model.*;
import View.ConsoleClient.ConsoleClient;
import View.ConsoleCommands.*;
import utils.FileWorker;
import utils.JSONParser;


import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        LinkedListCollectionManager collectionManager = new LinkedListCollectionManager();
        collectionManager.add(new Person("Tom", new Coordinates(10, 10), (long) 100, (float) 95.5,
                EyesColor.BLUE, HairsColor.BLACK, new Location(10L, 10, 100.F, "Moscow")));

        FileWorker fileWorker = new FileWorker(System.getProperty("user.dir") + "/../");
        JSONParser jsonParser = new JSONParser();
//        System.out.println(jsonParser.stringToJSON(collectionManager));
        fileWorker.saveFile(jsonParser.toJSON(collectionManager), "data/data.json");
////        fileWorker.logger();
//
//        Person p1 = new Person("Tom", 10, 20, (long) 100, (float) 95.5, EyesColor.BLUE, HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
//        Person p2 = new Person("Allan", 10, 20, (long) 100, (float) 95.5, EyesColor.BLUE, HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
//        Person p3 = new Person("Zidan", 10, 20, (long) 100, (float) 95.5, EyesColor.BLUE, HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
//        Person p4 = new Person("Aidan", 10, 20, (long) 100, (float) 95.5, EyesColor.BLUE, HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
//        Person p5 = new Person("Aidan", 10, 20, (long) 100, (float) 95.5, EyesColor.BLUE, HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
//        Person p6 = new Person("Hidan", 10, 20, (long) 100, (float) 95.5, EyesColor.BLUE, HairsColor.BROWN, (long) 10, 56, (float) 101.3, "Moscow");
//        Person p7 = new Person("Kakuzu", 25, 40, (long) 500, (float) 90.5, EyesColor.GREEN, HairsColor.WHITE, (long) 10, 56, (float) 101.3, "Konoha");
////

//
//
//        System.out.println(collectionManager.size());
////        fileWorker.readFile(args[0]);
        LinkedListCollectionManager personList = jsonParser.JSONParse(fileWorker.readFile("data/data.json"), LinkedListCollectionManager.class);

//        System.out.println(personList.getCollection());

//        if (personList != null) {
//            collectionManager.addAll(Arrays.asList(personList));
//        }
//
//        for (Person item : collectionManager.getCollection()) {
//            System.out.println(item.toString());
//        }
//
//        collectionManager.add(p1);
//        collectionManager.add(p2);
//        collectionManager.add(p3);
//        collectionManager.add(p4);
//        collectionManager.add(p5);
//        collectionManager.add(p6);
//        collectionManager.add(p7);
//


        ConsoleClient consoleClient = new ConsoleClient(

        );
        consoleClient.addCommands(new AbstractCommand[]{
                new HelpCommand(consoleClient),
                new InfoCommand(),
                new ShowCommand(collectionManager),
                new AddCommand(new PersonAsker(new Scanner(System.in)), collectionManager),
                new UpdateCommand(),
                new RemoveByIdCommand(collectionManager),
                new AddIfMinCommand(),
                new SaveCommand(),
                new ExitCommand(),
                new ExecuteScriptCommand(),
                new ClearCommand(collectionManager),
                new RemoveGreaterCommand(),
                new PrintDescendingCommand(),
                new PrintUniqueLocationCommand(),
                new CountByHeightCommand(),
                new RemoveFirstCommand(),
        });

//        consoleClient.help("help");

//        collectionManager.add(new PersonAsker(new Scanner(System.in)).startAsker());
//        for (Person p : collectionManager.getCollection()) {
//            System.out.println(p);
//        }
        consoleClient.executeCommand("add");
        consoleClient.executeCommand("show");
        consoleClient.executeCommand("remove_by_id " + collectionManager.getCollection().getFirst().getId());
        consoleClient.executeCommand("show");
    }


}



