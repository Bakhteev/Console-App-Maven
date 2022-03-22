package View.ConsoleCommands;

import Controller.PersonAsker.PersonMaker;
import Controller.collectionManagers.LinkedListCollectionManager;

public class AddCommand extends AbstractCommand {
    PersonMaker maker;
    LinkedListCollectionManager collectionManager;

    public AddCommand(PersonMaker maker, LinkedListCollectionManager collectionManager) {
        super("add", "add a new element to the collection.", "{element}");
        this.collectionManager = collectionManager;
        this.maker = maker;
    }

    @Override
    public boolean execute(String argument) {
        collectionManager.add(maker.startAsker());
        return true;
    }
}
