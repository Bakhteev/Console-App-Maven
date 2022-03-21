package View.ConsoleCommands;

import Controller.PersonAsker.PersonAsker;
import Controller.collectionManagers.LinkedListCollectionManager;

public class AddCommand extends AbstractCommand{
    PersonAsker asker ;
    LinkedListCollectionManager collectionManager;

    public AddCommand(PersonAsker asker, LinkedListCollectionManager collectionManager){
        super("add", "add a new element to the collection.", "{element}");
        this.collectionManager = collectionManager;
        this.asker = asker;
    }

    @Override
    public boolean execute(String argument) {
        collectionManager.add(asker.startAsker());
        return true;
    }
}
