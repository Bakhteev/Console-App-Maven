import collections.LinkedListCollection;
import fileWorker.FileWorker;
import model.Person;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException  {

        String dataPath = ".\\data\\";

        FileWorker fileWorker = new FileWorker();

        FileWorker.JSONParse("xui.json");

//        Person p1 = new Person("Tom", 10, 20, (long) 100, (float) 95.5, Person.EyesColor.BLUE, Person.HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
//        Person p2 = new Person("Allan", 10, 20, (long) 100, (float) 95.5, Person.EyesColor.BLUE, Person.HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
//        Person p3 = new Person("Zidan", 10, 20, (long) 100, (float) 95.5, Person.EyesColor.BLUE, Person.HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
//
//        Person p4 = new Person("Aidan", 10, 20, (long) 100, (float) 95.5, Person.EyesColor.BLUE, Person.HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
//        Person p5 = new Person("Aidan", 10, 20, (long) 100, (float) 95.5, Person.EyesColor.BLUE, Person.HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
//
//        LinkedListCollection<Person> list = new LinkedListCollection<>();
//        list.add(p3);
//        list.add(p1);
//
//        list.add(p2);
//
//        list.add(p4);
//        list.add(p4);
//
//        list.add(p5);
//        for (Person p : list) {
//            System.out.println(p);
//        }
//
    }


}
