package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;

public class InfoCommand extends AbstractCommand {
    LinkedListCollectionManager collectionManager ;
    public InfoCommand(LinkedListCollectionManager collectionManager) {
        super("info", "print information about the collection to standard output.", "");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        System.out.println("Collection initialization time: " + collectionManager.getInitializationTime() + "\n"
                + "Collection last save time: " + collectionManager.getLastSaveTime() + "\n"
                + "Collection type: " + collectionManager.getType() + "\n"
                + "Collection size: " + collectionManager.size() + "\n");
        return true;
    }
}
