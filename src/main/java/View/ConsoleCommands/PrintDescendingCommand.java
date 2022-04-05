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
        try {
            if (!argument.isEmpty())
                throw new IllegalArgumentException("Using of command: " + getName());
            if (collection.isEmpty())
                throw new IllegalArgumentException("Collection is empty");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        collection.stream().sorted(new PersonDescendingOrderComparator()).forEachOrdered(System.out::println);
        return true;
    }
}
