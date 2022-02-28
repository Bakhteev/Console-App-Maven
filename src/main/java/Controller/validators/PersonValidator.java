package Controller.validators;

import Model.EyesColor;
import Model.HairsColor;

public class PersonValidator {
    private void validatePerson(String name, Integer coordinatesX, int coordinatesY, Long height, float weight,
                                EyesColor eyesColor, HairsColor hairsColor, Long locationX, int locationY,
                                Float locationZ,
                                String locationName) throws IllegalArgumentException {
        if (name == null) throw new IllegalArgumentException("Name can't be empty");





        if (coordinatesX == null) throw new IllegalArgumentException("Coordinate x can't be empty");
        if (coordinatesY > 988) throw new IllegalArgumentException("Max value of coordinate y: 988");
        if (weight <= 0) throw new IllegalArgumentException("Value of weight must be more then 0");
        if (eyesColor == null) throw new IllegalArgumentException("Eyes' color can't be empty");
        if (height == null) throw new IllegalArgumentException("Height can't be empty");
        if(height <= 0) throw new IllegalArgumentException("Value of height must be more then 0");
        if(locationX == null) throw new IllegalArgumentException("Location x can't be empty");
        if(locationZ == null) throw new IllegalArgumentException("Location z can't be empty");
        if(locationName == null) throw new IllegalArgumentException("Location name can't be empty");
    }
}
