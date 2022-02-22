package Model;

import com.google.gson.annotations.SerializedName;

public enum EyesColor {
    @SerializedName("green")
    GREEN,
    @SerializedName("blue")
    BLUE,
    @SerializedName("orange")
    ORANGE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
