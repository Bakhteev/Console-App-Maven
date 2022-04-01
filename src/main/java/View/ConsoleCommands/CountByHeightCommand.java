package View.ConsoleCommands;
import Model.Person;

import java.util.LinkedList;

public class CountByHeightCommand extends AbstractCommand {
    LinkedList<Person> collection;

    public CountByHeightCommand(LinkedList<Person> collection) {
        super("count_by_height", "display the number of elements whose height field value is equal to the given one.",
                "height");
        this.collection = collection;
    }


    @Override
    public boolean execute(String argument) {
        long height = Long.parseLong(argument);
        long result = collection.stream().filter((Person p) -> p.getHeight() == height).count();
        System.out.println(result);
        return true;
    }
}
