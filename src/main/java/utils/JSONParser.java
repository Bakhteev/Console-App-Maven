package utils;

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

    public String stringToJSON(){
        String str = "{id: 1831089681,name: Aidan,coordinates: {x: 10,y: 20},creationDate: 2022-02-23T15:26:40.5451444,height: 100,weight: 95.5,eyesColor: blue,hairsColor: black,location: {x: 10,y: 56,z: 101.3,name: Moscow}},";
        Gson gson = Converters.registerLocalDateTime(new GsonBuilder().setPrettyPrinting().setLenient()).create();
        return gson.toJson(str);
//        return null;
    }
}
