package Model;

import com.google.gson.annotations.SerializedName;

public enum EyesColor {
    @SerializedName("green")
    GREEN,
    @SerializedName("blue")
    BLUE,
    @SerializedName("orange")
    ORANGE;

    static public void showColorsList() {
        for (EyesColor color : values()) {
            System.out.println(color);
        }
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }


}
