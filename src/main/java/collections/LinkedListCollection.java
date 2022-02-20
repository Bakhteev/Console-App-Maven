package collections;

import model.Person;
import comparators.PersonComparator;

import java.util.LinkedList;

public class LinkedListCollection<P extends Person> extends LinkedList<Person> {

    @Override
    public boolean add(Person person) {
        if (!this.checkUniqueId(person)) {
            throw new SecurityException("Person id must be unique");
        }
        super.add(person);
        super.sort(new PersonComparator());
        return true;
    }

    private boolean checkUniqueId(Person person) {
        for (Person item : this) {
            if (item.getId().equals(person.getId())) return false;
        }
        return true;
    }
}
