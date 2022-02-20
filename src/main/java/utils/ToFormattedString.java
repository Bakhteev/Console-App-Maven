package utils;

public class ToFormattedString<E> {

    E obj;

    public ToFormattedString(E obj) throws IllegalArgumentException {
        if (obj == null) throw new IllegalArgumentException("");
        this.obj = obj;
    }

    public String toJSON() {
        return "";
    }
}
