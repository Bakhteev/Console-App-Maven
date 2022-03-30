package Controller.PersonMaker;

import Controller.validators.PersonValidator;
import Model.*;
import java.util.Scanner;

public class PersonMaker {

    private final Scanner userScanner;
    private final PersonValidator validator = new PersonValidator();

    public PersonMaker(Scanner userScanner) {
        this.userScanner = userScanner;
    }


    private String askPersonName() {
        String name;
        while (true) {
            try {
                System.out.println("Enter person's name");
                name = userScanner.next();
                validator.validateName(name);
                name = name.trim();
                System.out.println(name);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }

    private Integer askCoordinatesX() {
        String strX = null;
        Integer x;
        while (true) {
            try {
                System.out.println("Enter X coordinate");
                strX = userScanner.next().trim();
                validator.validateCoordinatesX(strX);
                x = Integer.parseInt(strX);
                break;
            } catch (NumberFormatException e) {
                System.out.println(strX + " not a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return x;
    }


    private int askCoordinatesY() {
        String strY;
        int y;
        while (true) {
            try {
                System.out.println("Enter Y coordinate");
                strY = userScanner.next().trim();
                validator.validateCoordinatesY(strY);
                y = Integer.parseInt(strY);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return y;
    }


    private Coordinates coordinates() {
        Integer x = askCoordinatesX();
        int y = askCoordinatesY();
        return new Coordinates(x, y);
    }

    private Long askHeight() {
        String strHeight;
        Long height;
        while (true) {
            try {
                System.out.println("Enter person's height");
                strHeight = userScanner.next().trim();
                validator.validateHeight(strHeight);
                height = Long.parseLong(strHeight);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return height;
    }

    private float askWeight() {
        String strWeight;
        float weight;
        while (true) {
            try {
                System.out.println("Enter person's weight");
                strWeight = userScanner.next().trim();
                validator.validateWeight(strWeight);
                weight = Float.parseFloat(strWeight);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return weight;
    }

    private EyesColor askEyesColor() {
        String strColor;
        EyesColor color;
        while (true) {
            try {
                System.out.println("Choose eyes' color.");
                EyesColor.showColorsList();
                strColor = userScanner.next().trim().toUpperCase();
                color = EyesColor.valueOf(strColor);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Eyes color wasn't found.");
            }
        }
        return color;
    }

    private HairsColor askHairColor() {
        String strColor;
        HairsColor color;
        while (true) {
            try {
                System.out.println("Choose hairs' color.");
                HairsColor.showColorsList();
                strColor = userScanner.next().trim().toUpperCase();
                color = HairsColor.valueOf(strColor);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Hairs' color wasn't found.");
            }
        }
        return color;
    }

    private Long askLocationX() {
        String strX;
        Long x;
        while (true) {
            try {
                System.out.println("Enter Location X");
                strX = userScanner.next().trim();
                validator.validateLocationX(strX);
                x = Long.parseLong(strX);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return x;
    }

    private Integer askLocationY() {
        String strY;
        int y;
        while (true) {
            try {
                System.out.println("Enter Location Y");
                strY = userScanner.next().trim();
                if (strY.isEmpty()) {
                    return null;
                }
                y = Integer.parseInt(strY);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return (int) y;
    }

    private Float askLocationZ() {
        String strZ;
        Float z;
        while (true) {
            try {
                System.out.println("Enter Location Z");
                strZ = userScanner.next().trim();
                validator.validateLocationZ(strZ);
                z = Float.parseFloat(strZ);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return z;
    }

    private String askLocationName() {
        String name;
        while (true) {
            try {
                System.out.println("Enter Location's name");
                name = userScanner.next().trim();
                validator.validateName(name);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }

    private Location location() {
        Long x = askLocationX();
        int y = askLocationY();
        Float z = askLocationZ();
        String name = askLocationName();
        return new Location(x, y, z, name);
    }

    public Person startMaker() {
        String personName = askPersonName();
        Coordinates coordinates = this.coordinates();
        Long height = askHeight();
        float weight = askWeight();
        EyesColor eyesColor = askEyesColor();
        HairsColor hairsColor = askHairColor();
        Location location = this.location();
        return new Person(personName, coordinates, height, weight, eyesColor, hairsColor, location);
    }

}
