package View.ConsoleCommands;

import Exeptions.NoUniqueLocationException;
import Model.Person;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class PrintUniqueLocationCommand extends AbstractCommand {

    LinkedList<Person> collection;

    public PrintUniqueLocationCommand(LinkedList<Person> collection) {
        super("print_unique_location", "display the unique values of the location field of all elements in the collection.", "");
        this.collection = collection;
    }

    @Override
    public boolean execute(String argument) {
        HashMap<String, Integer> map = new HashMap<>();
        for (Person element : collection) {
            String locationName = element.getLocation().getName();
            if (map.containsKey(locationName))
                map.put(locationName, map.get(locationName) + 1);
            else
                map.put(locationName, 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String locationNameToShow = "";
            if (entry.getValue() == 1) {
                locationNameToShow = entry.getKey();
            }
            System.out.println(locationNameToShow.isEmpty() ? "No unique Location" : "Unique location is: " +  entry.getKey());
        }
        return true;
    }
}
