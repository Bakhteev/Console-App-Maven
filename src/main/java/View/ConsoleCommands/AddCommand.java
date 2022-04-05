package View.ConsoleCommands;

import Controller.PersonMaker.PersonMaker;
import Controller.collectionManagers.LinkedListCollectionManager;
import View.ConsoleClient.ConsoleClient;

public class AddCommand extends AbstractCommand {
    LinkedListCollectionManager collectionManager;

    public AddCommand(LinkedListCollectionManager collectionManager) {
        super("add", "add a new element to the collection.", "{element}");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty())
                throw new IllegalArgumentException("Using of command add: " + getName());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        PersonMaker maker = new PersonMaker(ConsoleClient.fileMode ? ConsoleClient.getScanners().getLast() : ConsoleClient.scanner);
        collectionManager.add(maker.startMaker());
        System.out.println("Person has successfully added");
        return true;
    }
}
