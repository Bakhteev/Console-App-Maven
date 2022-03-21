package Controller.collectionManagers;

import comparators.PersonNameComparator;
import Model.Person;

import java.util.*;

public class LinkedListCollectionManager {
    private final LinkedList<Person> collection = new LinkedList<>();

    public void add(Person person){
        if(checkUniqueId(person)){
            throw new SecurityException("Person id must be unique");
        }
        this.collection.add(person);
        this.collection.sort(new PersonNameComparator());
    }

    public void addAll(Collection<Person> collection){
        this.collection.addAll(collection);
    }

    public int size(){
        return collection.size();
    }

    public LinkedList<Person> getCollection(){
        return collection;
    }

    private boolean checkUniqueId(Person person) {
        for (Person item : collection) {
            if (item.getId().equals(person.getId())) return true;
        }
        return false;
    }

    public void clearCollection(){
        collection.clear();
    }

    public void showCollection(){
        System.out.println(collection);
    }

    public void removeElementById(int id) {
        collection.removeIf(element -> element.getId().equals(id));
    }
}
