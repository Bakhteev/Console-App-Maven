package Controller.collectionManagers;
import comparators.PersonNameComparator;
import Model.Person;
import java.time.LocalDateTime;
import java.util.*;


public class LinkedListCollectionManager {
    private final LinkedList<Person> collection = new LinkedList<>();
    private LocalDateTime initializationTime;
    private LocalDateTime lastSaveTime;
    private final String type = this.collection.getClass().getSimpleName() + " of " + Person.class.getSimpleName();

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
        if (size() == 0) {
            this.collection.addAll(collection);
            Set<Integer> setOfId = new HashSet<>();
            for (Person element : this.collection) {
                setOfId.add(element.getId());
            }
            for (Integer id : setOfId) {
                try {
                    int counter = 0;
                    for (Person element : this.collection) {
                        if (id.equals(element.getId())) counter++;
                    }
                    if (counter > 1) {
                        throw new SecurityException("Person id must be unique, objects with this id - " + id + " will be removed.\nNumber of " +
                                "objects: " + counter);
                    }
                } catch (SecurityException e) {
                    deleteById(id);
                    System.out.println(e.getMessage());
                }
            }
        } else {
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

    public void loadCollection(Person[] collection) {
        addAll(List.of(collection));
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

    public Person getElementById(Integer id) {
        Person person = null;
        for (Person element : collection) {
            if (element.getId().equals(id)) {
                person = element;
            }
        }
        return person;
    }

    public void setLastSaveTime() {
        lastSaveTime = LocalDateTime.now();
    }

    public String getType() {
        return type;
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

    public void deleteById(int id) {
        collection.removeIf(element -> element.getId().equals(id));
        collection.sort(new PersonNameComparator());
    }

    public void deleteObject(Person person){
        collection.remove(person);
        collection.sort(new PersonNameComparator());
    }

    public Person getFirstElement() {
        return collection.getFirst();
    }

    public void removeFirstElement() {
        collection.remove();
    }

}
