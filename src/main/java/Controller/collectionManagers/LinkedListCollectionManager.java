package Controller.collectionManagers;

import comparators.PersonNameComparator;
import Model.Person;

import java.time.LocalDateTime;
import java.util.*;


public class LinkedListCollectionManager {
    private final LinkedList<Person> collection = new LinkedList<>();
    private LocalDateTime initializationTime = LocalDateTime.now();
    private LocalDateTime lastSaveTime;

    public void add(Person person) {
        try {
            if (checkUniqueId(person)) {
                throw new SecurityException("Person id must be unique");
            }
            this.collection.add(person);
            this.collection.sort(new PersonNameComparator());
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addAll(Collection<Person> collection) {
        if (size() == 0){
            this.collection.addAll(collection);
            Set<Integer> setOfId = new HashSet<>();
            for (Iterator<Person> iterator = collection.iterator(); iterator.hasNext(); ){
                Person p = iterator.next();
                setOfId.add(p.getId());
            }

        }else {
            for (Iterator<Person> iterator = collection.iterator(); iterator.hasNext(); ) {
                try {
                    Person p = iterator.next();
                    if (checkUniqueId(p)) {
                        throw new SecurityException("Person id must be unique, this object will not be added to collection.\n" + p.toString());
                    }
                } catch (SecurityException e) {
                    System.out.println(e.getMessage());
                    iterator.remove();
                }
            }
        }
    }

    public void loadCollection(Collection<Person> collection){
        addAll(collection);
        initializationTime = LocalDateTime.now();
    }

    public int size() {
        return collection.size();
    }

    public LinkedList<Person> getCollection() {
        return collection;
    }

    public LocalDateTime getInitializationTime() {
        return initializationTime;
    }

    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    public void setLastSaveTime(){
        lastSaveTime = LocalDateTime.now();
    }

    private boolean checkUniqueId(Person person) {
        for (Person item : collection) {
            if (item.getId().equals(person.getId()))
                return true;
        }
        return false;
    }

//    private Collection<Person> checkUniqueId(){
//
//    }

    public void clearCollection() {
        collection.clear();
    }

    public void deleteById(int id) {
        collection.removeIf(element -> element.getId().equals(id));
    }

    public Person getFirstElement() {
        return collection.getFirst();
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
