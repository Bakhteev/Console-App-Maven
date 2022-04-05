package View.ConsoleCommands;

import Controller.PersonMaker.PersonMaker;
import Controller.collectionManagers.LinkedListCollectionManager;
import Exeptions.PersonNotFoundException;
import Model.HairsColor;
import Model.Person;
import View.ConsoleClient.ConsoleClient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class UpdateCommand extends AbstractCommand {
    private LinkedListCollectionManager collectionManager;

    public enum Fields {
        NAME,
        COORDINATES,
        HEIGHT,
        WEIGHT,
        HAIRSCOLOR,
        LOCATION;

        static public void showFieldList() {
            for (int i = 0; i < values().length - 1; i++) {
                System.out.println(values()[i].toString().toLowerCase(Locale.ROOT));
            }
        }
    }

    public UpdateCommand(LinkedListCollectionManager collectionManager) {
        super("update", "update the value of the collection element whose id is equal to the given one.",
                "id {element}");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {

//        HashMap<String, Method> setters = new HashMap<>();
//
//        Arrays.stream(Person.class.getDeclaredFields())
//                .filter(field -> !field.getName().equals("id"))
//                .filter(field -> !field.getName().equals("creationDate"))
//                .forEach(field ->
//                                System.out.println(field.getName()
//                        .replaceFirst(
//                        String.valueOf(field.getName().charAt(0)),
//                        String.valueOf(field.getName().toUpperCase().charAt(0))))
////                        setters.put(field.getName()
////                                .replaceFirst(
////                                        String.valueOf(field.getName().charAt(0)),
////                                        String.valueOf(field.getName().toUpperCase().charAt(0))),Person.class.getDeclaredMethod("set" + param, Person.class.getDeclaredField(param.toLowerCase()).getType()))
//                );
//        try {
//            System.out.println("Choose param name: ");
//            String param = scanner.next();
//            System.out.println("Type param value:\n");
//            String value = scanner.next();
//            Person.class.getDeclaredMethod("set" + param, Person.class.getDeclaredField(param.toLowerCase()).getType()).invoke(personToUpdate,
//                    value);
//        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println(personToUpdate.toString());

        try {
            if (argument.isEmpty())
                throw new IllegalArgumentException("Using of command :" + getName() + " " + getParameters());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        PersonMaker maker = new PersonMaker(ConsoleClient.fileMode ? ConsoleClient.getScanners().getLast() : ConsoleClient.scanner);
        try {
            Person personToUpdate = collectionManager.getElementById(Integer.parseInt(argument));
            if (personToUpdate == null) {
                throw new PersonNotFoundException("Person with id: " + argument + "wasn't found");
            }
            if (!ConsoleClient.fileMode) {
                Fields.showFieldList();
                System.out.println("Choose param's names: ");
                System.out.print("> ");
            }
            String[] params = ConsoleClient.scanner.nextLine().split(",");
            Arrays.stream(params).forEach(param -> maker.setPersonByFields(personToUpdate, param.replace(">", "").trim()));
            System.out.println(personToUpdate);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Wrong id Format: " + argument);
            return false;
        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
