package Controller.validators;

public class PersonValidator {
    private final int MAX_Y = 988;
    private final int MIN_VALUE = 0;

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

    public void validateLocationX(String strX) {
        if (strX.isEmpty())
            throw new IllegalArgumentException("Location x can't be empty");
    }

    public void validateLocationZ(String strZ) {
        if (strZ.isEmpty())
            throw new IllegalArgumentException("Location Z can't be empty");
    }

}
