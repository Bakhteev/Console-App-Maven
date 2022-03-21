package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;

public class ClearCommand extends AbstractCommand {
    LinkedListCollectionManager collectionManager;

    public ClearCommand(LinkedListCollectionManager collectionManager) {
        super("clear", "clears collection", "");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        collectionManager.clearCollection();
        return true;
    }
}
