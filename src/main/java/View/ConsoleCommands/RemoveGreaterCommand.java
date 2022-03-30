package View.ConsoleCommands;

import Controller.PersonMaker.PersonMaker;
import Controller.collectionManagers.LinkedListCollectionManager;
import Model.*;

public class RemoveGreaterCommand extends AbstractCommand {
    private PersonMaker maker;
    private LinkedListCollectionManager collectionManager;

    public RemoveGreaterCommand(PersonMaker maker, LinkedListCollectionManager collectionManager) {
        super("remove_greater", "remove from the collection all elements greater than the given.",
                "{element}");

        this.maker = maker;
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        Person personToCompare = new Person("XUI", new Coordinates(10, 10), (long) 175, (float) 80, EyesColor.BLUE, HairsColor.BLACK,
                new Location(10L
                , 10, 100.F, "Moscow"));
//        Person personToCompare = maker.startMaker();
        for (Person person : collectionManager.getCollection()) {
            System.out.println(person.getHeight() > personToCompare.getHeight() && person.getWeight() > personToCompare.getWeight());
            if (person.getHeight().compareTo(personToCompare.getHeight()) + person.getWeight().compareTo(personToCompare.getWeight()) > 0 ) {
                System.out.println(person);
                collectionManager.deleteObject(person);
            }
        }
        return true;
    }
}
