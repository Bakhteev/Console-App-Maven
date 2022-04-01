package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;
import Model.Person;
import comparators.PersonDescendingOrderComparator;

import java.util.LinkedList;

public class PrintDescendingCommand extends AbstractCommand {

    private LinkedList<Person> collection;

    public PrintDescendingCommand(LinkedList<Person> collection) {
        super("print_descending", "display the elements of the collection in descending order.", "");
        this.collection = collection;
    }

    @Override
    public boolean execute(String argument) {
        collection.stream().sorted(new PersonDescendingOrderComparator()).forEachOrdered(System.out::println);
        return true;
    }
}
