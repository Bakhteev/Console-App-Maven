package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;

public class PrintUniqueLocationCommand extends AbstractCommand{

    LinkedListCollectionManager collectionManager;

    public PrintUniqueLocationCommand(LinkedListCollectionManager collectionManager) {
        super("print_unique_location", "display the unique values of the location field of all elements in the collection.", "");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        System.out.println(collectionManager.searchUniqueLocationName());
        return true;
    }
}
