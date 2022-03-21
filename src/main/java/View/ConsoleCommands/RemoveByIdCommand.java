package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;

public class RemoveByIdCommand extends AbstractCommand {
    LinkedListCollectionManager collectionManager ;

    public RemoveByIdCommand(LinkedListCollectionManager collectionManager) {
        super("remove_by_id", "remove element from collection by its id.", "id");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        collectionManager.removeElementById(Integer.parseInt(argument.split(" ")[0]));
        return false;
    }
}
