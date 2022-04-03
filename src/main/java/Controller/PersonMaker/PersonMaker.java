package Controller.PersonMaker;

import Controller.validators.PersonValidator;
import Model.*;
import View.ConsoleCommands.UpdateCommand;

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
                name = userScanner.nextLine();
                validator.validateName(name);
                name = name.trim();
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
                strX = userScanner.nextLine().trim();
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
        String strY = null;
        int y;
        while (true) {
            try {
                System.out.println("Enter Y coordinate");
                strY = userScanner.nextLine().trim();
                validator.validateCoordinatesY(strY);
                y = Integer.parseInt(strY);
                break;
            } catch (NumberFormatException e) {
                System.out.println(strY + " not a number");
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
        String strHeight = null;
        Long height;
        while (true) {
            try {
                System.out.println("Enter person's height");
                strHeight = userScanner.nextLine().trim();
                validator.validateHeight(strHeight);
                height = Long.parseLong(strHeight);
                break;
            } catch (NumberFormatException e) {
                System.out.println(strHeight + " not a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return height;
    }

    private float askWeight() {
        String strWeight = null;
        float weight;
        while (true) {
            try {
                System.out.println("Enter person's weight");
                strWeight = userScanner.nextLine().trim();
                validator.validateWeight(strWeight);
                weight = Float.parseFloat(strWeight);
                break;
            } catch (NumberFormatException e) {
                System.out.println(strWeight + " not a number");
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
                strColor = userScanner.nextLine().trim().toUpperCase();
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
                strColor = userScanner.nextLine().trim().toUpperCase();
                color = HairsColor.valueOf(strColor);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Hairs' color wasn't found.");
            }
        }
        return color;
    }

    private Long askLocationX() {
        String strX = null;
        Long x;
        while (true) {
            try {
                System.out.println("Enter Location X");
                strX = userScanner.nextLine().trim();
                validator.validateLocationX(strX);
                x = Long.parseLong(strX);
                break;
            } catch (NumberFormatException e) {
                System.out.println(strX + " not a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return x;
    }

    private Integer askLocationY() {
        String strY = null;
        int y;
        while (true) {
            try {
                System.out.println("Enter Location Y");
                strY = userScanner.nextLine().trim();
                if (strY.isEmpty()) {
                    return null;
                }
                y = Integer.parseInt(strY);
                break;
            } catch (NumberFormatException e) {
                System.out.println(strY + " not a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return y;
    }

    private Float askLocationZ() {
        String strZ = null;
        Float z;
        while (true) {
            try {
                System.out.println("Enter Location Z");
                strZ = userScanner.nextLine().trim();
                validator.validateLocationZ(strZ);
                z = Float.parseFloat(strZ);
                break;
            } catch (NumberFormatException e) {
                System.out.println(strZ + " not a number");
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
                name = userScanner.nextLine().trim();
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

    public void setPersonByFields(Person personToUpdate, String param) {
        if (UpdateCommand.Fields.valueOf(param).equals(UpdateCommand.Fields.Name)) {
            String name = askPersonName();
            personToUpdate.setName(name);
        }
        if (UpdateCommand.Fields.valueOf(param).equals(UpdateCommand.Fields.Coordinates)) {
            personToUpdate.setCoordinates(coordinates());
        }
        if (UpdateCommand.Fields.valueOf(param).equals(UpdateCommand.Fields.Height)) {
            personToUpdate.setHeight(askHeight());
        }
        if (UpdateCommand.Fields.valueOf(param).equals(UpdateCommand.Fields.Weight)) {
            personToUpdate.setWeight(askWeight());
        }
        if (UpdateCommand.Fields.valueOf(param).equals(UpdateCommand.Fields.HairsColor)) {
            personToUpdate.setHairsColor(askHairColor());
        }
        if (UpdateCommand.Fields.valueOf(param).equals(UpdateCommand.Fields.Location)) {
            personToUpdate.setLocation(location());
        }
    }

}
