package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;

public class CountByHeightCommand extends AbstractCommand {
    LinkedListCollectionManager collectionManager;
    public CountByHeightCommand(LinkedListCollectionManager collectionManager) {
        super("count_by_height", "display the number of elements whose height field value is equal to the given one.",
                "height");
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean execute(String argument) {
        long numberOfHeight = collectionManager.countByHeight(Long.parseLong(argument));
        System.out.println(numberOfHeight);
        return true;
    }
}
