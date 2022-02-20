import collections.LinkedListCollection;
import fileWorker.FileWorker;
import model.Person;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException  {

        FileWorker fileWorker = new FileWorker();

        Person p1 = new Person("Tom", 10, 20, (long) 100, (float) 95.5, Person.EyesColor.BLUE, Person.HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
        Person p2 = new Person("Allan", 10, 20, (long) 100, (float) 95.5, Person.EyesColor.BLUE, Person.HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
        Person p3 = new Person("Zidan", 10, 20, (long) 100, (float) 95.5, Person.EyesColor.BLUE, Person.HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");

        Person p4 = new Person("Aidan", 10, 20, (long) 100, (float) 95.5, Person.EyesColor.BLUE, Person.HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
        Person p5 = new Person("Aidan", 10, 20, (long) 100, (float) 95.5, Person.EyesColor.BLUE, Person.HairsColor.BLACK, (long) 10, 56, (float) 101.3, "Moscow");
        Person p6 = new Person("Hidan", 10, 20, (long) 100, (float) 95.5, Person.EyesColor.BLUE,
                Person.HairsColor.BROWN, (long) 10, 56, (float) 101.3, "Moscow");

        LinkedListCollection<Person> list = new LinkedListCollection<>();
        list.add(p3);
        list.add(p1);

        list.add(p2);

        list.add(p4);
        list.add(p6);

        list.add(p5);

        fileWorker.toJSON(list,"xui.json");
//        fileWorker.JSONParse("xui.json");

    }


}
