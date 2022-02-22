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

//    @Override
//    public boolean add(Person person) {
//        if (this.checkUniqueId(person)) {
//            throw new SecurityException("Person id must be unique");
//        }
//        super.add( person);
//        super.sort(new PersonComparator());
//        return true;
//    }
//
////    @Override
////    public boolean addAll(int index, Collection<? extends Person> c) {
////        ArrayList<Person> collection = new ArrayList<>();;
////        ArrayList<Person> notUniqueIds = new ArrayList<>();
////        for (Person person: collection){
////            if (checkUniqueId(person)){
////                notUniqueIds.add(person);
////            }
////            collection.add(person);
////        }
////        checkUniqueIds(notUniqueIds);
////        super.addAll(index, collection);
////        super.sort(new PersonComparator());
////        return true;
////    }
//
////    @Override
////    public boolean addAll(Collection<? extends Person> c) {
////        ArrayList<Person> collection = new ArrayList<>();
////        ArrayList<Person> notUniqueIds = new ArrayList<>();
////        for (Person person: collection){
////            if (checkUniqueId(person)){
////                notUniqueIds.add(person);
////            }
////            collection.add(person);
////        }
////        checkUniqueIds(notUniqueIds);
////        super.addAll(collection);
////        super.sort(new PersonComparator());
////        return true;
////    }
//
    private boolean checkUniqueId(Person person) {
        for (Person item : collection) {
            if (item.getId().equals(person.getId())) return true;
        }
        return false;
    }
////    private boolean checkUniqueIds(ArrayList<Person> array){
////        if (array.size() > 0){
////            StringBuilder str = new StringBuilder("Person id must be unique. This items didn't pass the " +
////                    "test and were automatically deleted: \n");
////            for(Person person: array){
////                str.append(person);
////                str.append("\n");
////            }
////            throw new SecurityException(String.valueOf(str));
////        }
////        return false;
////    }

}
