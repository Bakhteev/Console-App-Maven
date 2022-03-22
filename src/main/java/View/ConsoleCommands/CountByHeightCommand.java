package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;
import Model.Person;

import java.util.LinkedList;

public class CountByHeightCommand extends AbstractCommand {
    LinkedList<Person> collection;

    public CountByHeightCommand(LinkedList<Person> collection) {
        super("count_by_height", "display the number of elements whose height field value is equal to the given one.",
                "height");
    }


    @Override
    public boolean execute(String argument) {
        long height = Long.parseLong(argument);
        long counter = 0;
        for (Person element : collection) {
            if (element.getHeight() == height) {
                counter++;
            }
        }
        System.out.println(counter);
        return true;
    }
}
