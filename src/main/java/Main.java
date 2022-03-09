import Controller.collectionManagers.LinkedListCollectionManager;
import Model.EyesColor;
import Model.HairsColor;
import Model.Person;
import View.ConsoleClient.ConsoleClient;
import View.ConsoleCommands.*;


import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

//        FileWorker fileWorker = new FileWorker(System.getProperty("user.dir") + "/../");
//        JSONParser jsonParser = new JSONParser();
//
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
        LinkedListCollectionManager collectionManager = new LinkedListCollectionManager();
//
//
//        System.out.println(collectionManager.size());
////        fileWorker.readFile(args[0]);
//        Person[] personList = jsonParser.JSONParse(fileWorker.readFile("data/data.json"), Person[].class);
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
//        fileWorker.saveFile(jsonParser.toJSON(collectionManager.getCollection()), "data/data.json");


        ConsoleClient consoleClient = new ConsoleClient(
                new AbstractCommand[]{
                        new HelpCommand(),
                        new InfoCommand(),
                        new ShowCommand(),
                        new AddCommand(),
                        new UpdateCommand(),
                        new RemoveByIdCommand(),
                        new AddIfMinCommand(),
                        new SaveCommand(),
                        new ExitCommand(),
                        new ExecuteScriptCommand(),
                        new ClearCommand(),
                        new RemoveGreaterCommand(),
                        new PrintDescendingCommand(),
                        new PrintUniqueLocationCommand(),
                        new CountByHeightCommand(),
                        new RemoveFirstCommand(),
                }
        );

        consoleClient.help("help");

    }


}



