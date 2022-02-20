package fileWorker;
import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

public class FileWorker {
    static String dataPath = System.getProperty("user.dir");

    public void logger(){
        System.out.println(dataPath);
    }

    public<T> T JSONParse(String filePath, Class<T> classOfT) throws IOException {
        Path file = Paths.get(dataPath + filePath);
        InputStreamReader reader = new FileReader("D:/ITMO_Lerning/Proga/data/" + filePath);

        StringBuilder jsonString = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            jsonString.append((char) c);
        }
        Gson gson = Converters.registerLocalDateTime(new GsonBuilder()).create();

        return gson.fromJson(String.valueOf(jsonString), classOfT);
    }

    public void toJSON(Collection<?> collection, String filePath) throws IOException {
        Gson gson = Converters.registerLocalDateTime(new GsonBuilder().setPrettyPrinting()).create();
        String str = gson.toJson(collection);

        OutputStreamWriter writer = new FileWriter("D:/ITMO_Lerning/Proga/data/" + filePath);
        writer.write(str);
        writer.flush();
    }
}
