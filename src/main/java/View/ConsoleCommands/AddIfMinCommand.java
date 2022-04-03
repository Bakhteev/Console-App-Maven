package View.ConsoleCommands;

import Controller.PersonMaker.PersonMaker;
import Controller.collectionManagers.LinkedListCollectionManager;
import Model.*;
import comparators.MinPersonComparator;
import comparators.PersonNameComparator;

import java.util.Optional;

public class AddIfMinCommand extends AbstractCommand {

    private LinkedListCollectionManager collectionManager;
    private PersonMaker maker;

    public AddIfMinCommand(LinkedListCollectionManager collectionManager, PersonMaker maker) {
        super("add_if_min", "add a new element to the collection if its value is less than the smallest " +
                "element in this collection.", "{element}");
        this.collectionManager = collectionManager;
        this.maker = maker;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (collectionManager.size() == 0) {
                System.out.println("collection is empty");
                return false;
            }
            Optional<Person> minPerson = collectionManager.getCollection().stream().min(new MinPersonComparator());
            Person candidate = maker.startMaker();
            if (new MinPersonComparator().compare(minPerson.get(), candidate) > 0) {
                collectionManager.add(candidate);
                System.out.println("Person has successfully added");
            }
            return true;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
