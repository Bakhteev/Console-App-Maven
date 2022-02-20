package fileWorker;


import collections.LinkedListCollection;
import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Person;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;

public class FileWorker {

    static String dataPath = System.getProperty("user.dir");

    public void JSONParse(String filePath) throws IOException {
        Path file = Paths.get(dataPath + filePath);
        InputStreamReader reader = new FileReader("D:/ITMO_Lerning/Proga/data/" + filePath);

        StringBuilder jsonString = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            jsonString.append((char) c);
        }
        Gson gson = Converters.registerLocalDateTime(new GsonBuilder()).create();
        Person[] person = gson.fromJson(String.valueOf(jsonString), (Type) Person[].class);
        for (Person item: person){
            System.out.println(item.getColor());
        }
    }

    public void toJSON(LinkedList<?> collection, String filePath) throws IOException {
        Gson gson = Converters.registerLocalDateTime(new GsonBuilder().setPrettyPrinting()).create();
        String str = gson.toJson(collection);

        System.out.println(str);

        OutputStreamWriter writer = new FileWriter("D:/ITMO_Lerning/Proga/data/" + filePath);
        writer.write(str);
        writer.flush();
    }
}
