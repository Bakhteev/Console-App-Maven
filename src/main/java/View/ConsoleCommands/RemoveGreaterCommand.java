package View.ConsoleCommands;

import Controller.PersonMaker.PersonMaker;
import Controller.collectionManagers.LinkedListCollectionManager;
import Model.*;

import java.util.ArrayList;

public class RemoveGreaterCommand extends AbstractCommand {
    private PersonMaker maker;
    private LinkedListCollectionManager collectionManager;

    public RemoveGreaterCommand(PersonMaker maker, LinkedListCollectionManager collectionManager) {
        super("remove_greater", "remove from the collection all elements greater than the given.",
                "{element}");

        this.maker = maker;
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        if(collectionManager.size() == 0){
            System.out.println("collection is empty");
            return false;
        }
        Person personToCompare = maker.startMaker();
        ArrayList<Person> listToRemove = new ArrayList<>();

        collectionManager.getCollection().stream()
                .filter((Person person) -> person.getWeight() > personToCompare.getWeight() && person.getHeight() > personToCompare.getHeight())
                .forEach(listToRemove::add);

        listToRemove.forEach(collectionManager::deleteObject);
        return true;
    }
}
