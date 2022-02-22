package Model;

public class Location {
    private Long x; //Поле не может быть null
    private int y;
    private Float z; //Поле не может быть null
    private String name; //Поле не может быть null

    public Location(Long x, int y, Float z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + " x: " + x + ";" + " y: " + y + ";" + " z: " + z + ";" + " name: '" + name + "'; " + '}';
    }
}
