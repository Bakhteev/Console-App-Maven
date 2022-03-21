package Controller.collectionManagers;

import comparators.PersonNameComparator;
import Model.Person;

import java.util.*;


public class LinkedListCollectionManager {
    private final LinkedList<Person> collection = new LinkedList<>();

    public void add(Person person) {
        if (checkUniqueId(person)) {
            throw new SecurityException("Person id must be unique");
        }
        this.collection.add(person);
        this.collection.sort(new PersonNameComparator());
    }

    public void addAll(Collection<Person> collection) {
        this.collection.addAll(collection);
    }

    public int size() {
        return collection.size();
    }

    public LinkedList<Person> getCollection() {
        return collection;
    }

    private boolean checkUniqueId(Person person) {
        for (Person item : collection) {
            if (item.getId().equals(person.getId()))
                return true;
        }
        return false;
    }

    public void clearCollection() {
        collection.clear();
    }

    public void showCollection() {
        System.out.println(collection);
    }

    public void removeElementById(int id) {
        collection.removeIf(element -> element.getId().equals(id));
    }

    public long countByHeight(long height) {
        long counter = 0;
        for (Person element : collection) {
            if (element.getHeight() == height) {
                counter++;
            }
        }
        return counter;
    }

    public void removeFirstElement() {
        collection.remove();
    }

    public String searchUniqueLocationName() {
        long counter = 0;
        String location = collection.get(0).getLocation().getName();
//        for (int i = 1; i < collection.size(); i++) {
//            for (int j = 1; j < collection.size(); j++) {
//                if (location.equals(collection.get(j).getLocation().getName())) {
//                    counter++;
//                    System.out.println(location + " " + counter);
//                }
//            }
//            if (counter == 0)
//                break;
//            counter = 0;
//        }
        return location;
    }
}
