package View.ConsoleCommands;

import Controller.collectionManagers.LinkedListCollectionManager;
import Model.Person;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class UpdateCommand extends AbstractCommand {
    private LinkedListCollectionManager collectionManager;

    public UpdateCommand(LinkedListCollectionManager collectionManager) {
        super("update", "update the value of the collection element whose id is equal to the given one.",
                "id {element}");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        Arrays.stream(Person.class.getDeclaredFields())
                .filter(field -> !field.getName().equals("id"))
                .filter(field -> !field.getName().equals("creationDate"))
                .forEach(field -> System.out.println(field.getName().replaceFirst(
                        String.valueOf(field.getName().charAt(0)),
                        String.valueOf(field.getName().toUpperCase().charAt(0)))));
        Person personToUpdate = collectionManager.getElementById(Integer.parseInt(argument));
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose param name: ");
            String param = scanner.nextLine();
            System.out.println("Type param value:\n");
            String value = scanner.nextLine();
            Person.class.getDeclaredMethod("set" + param, Person.class.getDeclaredField(param.toLowerCase()).getType()).invoke(personToUpdate,
                    value);
        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(personToUpdate.toString());
        return false;
    }
}
