package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;
import Model.Person;

public class AddCommand extends AbstractCommand{

    LinkedListCollectionManager collectionManager;

    public AddCommand(LinkedListCollectionManager collectionManager){
        super("add", "add a new element to the collection.", "{element}");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        return false;
    }
}
