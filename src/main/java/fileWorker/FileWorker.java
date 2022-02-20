package fileWorker;


import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileWorker {

    static String dataPath = System.getProperty("user.dir");

    static public void JSONParse(String filePath) throws IOException {
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
            System.out.println(item.getId());
            System.out.println(item.toString());

        }
    }
}
