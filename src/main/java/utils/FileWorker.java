package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class FileWorker {
    public String filePath;

    //
    public FileWorker(String filePath) {
        this.filePath = filePath;
    }

    public void logger() {
        System.out.println(filePath);
    }

    public String readFile() {

        StringBuilder jsonString = new StringBuilder();
        File file = new File(filePath);
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

    public void saveFile(String data) throws IOException {
//       OutputStreamWriter writer = new FileWriter(dataPath + fileName);
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath),
                StandardCharsets.UTF_8);
        writer.write(data);
        writer.flush();
        writer.close();
    }
}
