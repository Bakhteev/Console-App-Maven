import collections.LinkedListCollection;
import fileWorker.FileWorker;
import model.Person;

import java.io.IOException;
import java.util.Arrays;


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
        Person[] personList =  fileWorker.JSONParse("xui.json", Person[].class);

        list.addAll(Arrays.asList(personList));

        Person p7 = new Person("Kakuzu", 25, 40, (long) 500, (float) 90.5, Person.EyesColor.GREEN,
                Person.HairsColor.WHITE, (long) 10, 56, (float) 101.3, "Konoha");
        list.add(p7);
        fileWorker.logger();
    }


}
