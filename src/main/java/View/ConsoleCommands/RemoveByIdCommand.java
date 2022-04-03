package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;

public class RemoveByIdCommand extends AbstractCommand {
    LinkedListCollectionManager collectionManager;

    public RemoveByIdCommand(LinkedListCollectionManager collectionManager) {
        super("remove_by_id", "remove element from collection by its id.", "id");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try{
            collectionManager.deleteById(Integer.parseInt(argument));
            System.out.println("Element was successfully deleted");
            return true;
        }catch(NumberFormatException e){
            System.out.println("Wrong id format");
            return false;
        }
    }
}
