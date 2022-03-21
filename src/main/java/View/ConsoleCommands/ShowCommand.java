package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;

public class ShowCommand extends AbstractCommand {
    LinkedListCollectionManager collectionManager;
    public ShowCommand(LinkedListCollectionManager collectionManager){
        super("show", "print to standard output all elements of the collection in string representation.", "");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        collectionManager.showCollection();
        return false;
    }
}
