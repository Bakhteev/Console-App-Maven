package comparators;

import model.Person;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {


    @Override
    public int compare(Person p1, Person p2) {
//        int result = 0;

        return p1.getName().compareTo(p2.getName());

//        return result;

    }
}
