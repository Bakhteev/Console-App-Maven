package utils;

import Controller.collectionManagers.LinkedListCollectionManager;
import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Collection;

public class JSONParser {

    public<T> T JSONParse(String data, Class<T> classOfT) throws IOException {
        Gson gson = Converters.registerLocalDateTime(new GsonBuilder()).create();
        return gson.fromJson(String.valueOf(data), classOfT);
    }

    public String toJSON(Collection<?> collection) throws IOException {
        Gson gson = Converters.registerLocalDateTime(new GsonBuilder().setPrettyPrinting()).create();
        return gson.toJson(collection);
    }

    public String toJSON(LinkedListCollectionManager manager){
        Gson gson = Converters.registerLocalDateTime(new GsonBuilder().setPrettyPrinting()).create();
        return gson.toJson(manager);
    }
}
