package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;
import Model.Person;

import java.util.LinkedList;

public class ShowCommand extends AbstractCommand {
    LinkedList<Person> collection;

    public ShowCommand(LinkedList<Person> collection) {
        super("show", "print to standard output all elements of the collection in string representation.", "");
        this.collection = collection;
    }

    @Override
    public boolean execute(String argument) {
        System.out.println(collection);
        return false;
    }
}
