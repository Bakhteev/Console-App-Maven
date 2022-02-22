package Model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Person implements Comparable<Person> {
    private final Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно
    // быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long height; //Поле не может быть null, Значение поля должно быть больше 0
    private float weight; //Значение поля должно быть больше 0
    private final EyesColor eyesColor; //Поле не может быть null
    private HairsColor hairsColor; //Поле не может быть null
    private Location location; //Поле не может быть null

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.getName());
    }

    public Person(String name, Integer coordinatesX, int coordinatesY, Long height, float weight, EyesColor eyesColor,
                  HairsColor hairsColor, Long locationX, int locationY, Float locationZ, String locationName) throws IllegalArgumentException {
        this.id = this.uniqueId();
        this.name = name;
        this.coordinates = new Coordinates(coordinatesX, coordinatesY);
        this.creationDate = LocalDateTime.now();
        this.height = height;
        this.weight = weight;
        this.eyesColor = eyesColor;
        this.hairsColor = hairsColor;
        this.location = new Location(locationX, locationY, locationZ, locationName);
    }

    private int uniqueId() {
        UUID uniqueKey = UUID.randomUUID();
        return Math.abs(uniqueKey.hashCode());
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HairsColor getColor(){
        return this.hairsColor;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "{\n" +
                "   id: " + id + ";\n" +
                "   name: '" + name + '\'' + ";\n" +
                "   coordinates: " + coordinates.toString() + ";\n" +
                "   creationDate: " + creationDate.toString() + ";\n" +
                "   height: " + height + ";\n" +
                "   weight: " + weight + ";\n" +
                "   eyeColor: " + eyesColor.toString() + ";\n" +
                "   hairColor: " + hairsColor.toString() + ";\n" +
                "   location: " + location.toString() + ";\n" +
                "}";
    }
}
