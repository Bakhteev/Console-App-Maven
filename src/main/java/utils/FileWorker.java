package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class FileWorker {
    public String dataPath;

    //
    public FileWorker(String property) {
        dataPath = property;
    }

    public void logger() {
        System.out.println(dataPath);
    }

    public String readFile(String fileName) {

        StringBuilder jsonString = new StringBuilder();
        File file = new File(dataPath + fileName);
        try (Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        ) {
            int c;
            while ((c = reader.read()) != -1) {
                jsonString.append((char) c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(jsonString);
    }

    public void saveFile(String data, String fileName) throws IOException {
//       OutputStreamWriter writer = new FileWriter(dataPath + fileName);
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(dataPath + fileName), StandardCharsets.UTF_8);
        writer.write(data);
        writer.flush();
        writer.close();
    }
}
