package Model;

import com.google.gson.annotations.SerializedName;

public enum HairsColor {
    @SerializedName("black")
    BLACK,
    @SerializedName("white")
    WHITE,
    @SerializedName("brown")
    BROWN;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
