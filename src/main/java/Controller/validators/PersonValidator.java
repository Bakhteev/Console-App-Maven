package Controller.validators;

import Model.EyesColor;
import Model.HairsColor;

public class PersonValidator {
    private final int MAX_Y = 988;
    private final int MIN_VALUE = 0;

    private void validatePerson(String name, Integer coordinatesX, int coordinatesY, Long height, float weight,
                                EyesColor eyesColor, HairsColor hairsColor, Long locationX, int locationY,
                                Float locationZ,
                                String locationName) throws IllegalArgumentException {
        if (name == null)
            throw new IllegalArgumentException("Name can't be empty");


        if (coordinatesX == null)
            throw new IllegalArgumentException("Coordinate x can't be empty");
        if (coordinatesY > 988)
            throw new IllegalArgumentException("Max value of coordinate y: 988");
        if (weight <= 0)
            throw new IllegalArgumentException("Value of weight must be more then 0");
        if (eyesColor == null)
            throw new IllegalArgumentException("Eyes' color can't be empty");
        if (height == null)
            throw new IllegalArgumentException("Height can't be empty");
        if (height <= 0)
            throw new IllegalArgumentException("Value of height must be more then 0");
        if (locationX == null)
            throw new IllegalArgumentException("Location x can't be empty");
        if (locationZ == null)
            throw new IllegalArgumentException("Location z can't be empty");
        if (locationName == null)
            throw new IllegalArgumentException("Location name can't be empty");
    }

    public void validateName(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Name can't be empty");
    }

    public void validateCoordinatesX(String strX) {
        if (strX.isEmpty())
            throw new IllegalArgumentException("Coordinate x can't be empty");
    }

    public void validateCoordinatesY(String strY) {
        if (strY.isEmpty())
            throw new IllegalArgumentException("Coordinate " +
                    "y " +
                    "can't be empty");
        if (Integer.parseInt(strY) > MAX_Y)
            throw new IllegalArgumentException("Max value of coordinate y: 988");
    }

    public void validateHeight(String height) {
        if (height == null)
            throw new IllegalArgumentException("Height can't be empty");
        if (Long.parseLong(height) <= MIN_VALUE)
            throw new IllegalArgumentException("Value of height must be more then 0");
    }

    public void validateWeight(String strWeight) {
        if (strWeight.isEmpty())
            throw new IllegalArgumentException("weight can't be empty");
        if (Float.parseFloat(strWeight) <= MIN_VALUE)
            throw new IllegalArgumentException("Value of weight must be more then 0");
    }

}
