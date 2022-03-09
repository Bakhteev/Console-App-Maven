package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;
import Model.Person;

public class AddCommand extends AbstractCommand{

    public AddCommand(){
        super("add", "add a new element to the collection.", "{element}");
    }

    @Override
    public boolean execute(String argument) {

        return false;
    }
}
