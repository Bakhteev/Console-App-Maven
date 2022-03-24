package comparators;

import Model.Person;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName()) != 0 ? p1.getName().compareTo(p2.getName()):
                p1.getHeight().compareTo(p2.getHeight()) != 0 ? p1.getHeight().compareTo(p2.getHeight()) :
                        p1.getWeight().compareTo(p2.getWeight());
    }

}
