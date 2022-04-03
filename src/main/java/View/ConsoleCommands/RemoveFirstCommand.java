package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;

public class RemoveFirstCommand extends AbstractCommand {
    LinkedListCollectionManager collectionManager;

    public RemoveFirstCommand(LinkedListCollectionManager collectionManager) {
        super("remove_first", "remove first element of collection", "");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        if (collectionManager.size() == 0) {
            System.out.println("collection is empty");
            return false;
        }
        collectionManager.removeFirstElement();
        return true;
    }
}
