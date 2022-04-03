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
        try{
            if (collection.size() == 0){
                System.out.println("collection is empty");
                return false;
            }
            long height = Long.parseLong(argument);
            long result = collection.stream().filter((Person p) -> p.getHeight() == height).count();
            System.out.println(result);
            return true;
        }catch(NumberFormatException e){
            System.out.println(argument + " is not a number");
            return false;
        }
    }
}
