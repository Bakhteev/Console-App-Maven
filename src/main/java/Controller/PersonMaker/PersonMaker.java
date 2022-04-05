package Controller.PersonMaker;

import Controller.validators.PersonValidator;
import Model.*;
import View.ConsoleClient.ConsoleClient;
import View.ConsoleCommands.UpdateCommand;

import java.util.Locale;
import java.util.Scanner;

public class PersonMaker {

    private final Scanner userScanner;
    private final PersonValidator validator = new PersonValidator();

    public PersonMaker(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    private void printArgumentSymbol() {
        System.out.print("> ");
    }


    private void detectArgument(String argument) {
        if (!argument.startsWith(">")) {
            ConsoleClient.printParam("Wrong argument");
            System.exit(0);
        }
    }

    private String convertStringAsArgument(String argument) {
        return argument.replace("> ", "");
    }

    private String askPersonName() {
        System.out.println("Enter person's name");
        String name;
        if (ConsoleClient.fileMode) {
            name = userScanner.nextLine().trim();
            detectArgument(name);
            name = convertStringAsArgument(name);
            validator.validateName(name);
            ConsoleClient.printParam(name);
            return name;
        }
        while (true) {
            try {
                printArgumentSymbol();
                name = userScanner.nextLine().trim();
                validator.validateName(name);
                return name;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private Integer askCoordinatesX() {
        String strX = "";
        System.out.println("Enter X coordinate");
        if (ConsoleClient.fileMode) {
            strX = userScanner.nextLine().trim();
            detectArgument(strX);
            strX = convertStringAsArgument(strX);
            validator.validateCoordinatesX(strX);
            ConsoleClient.printParam(strX);
            return Integer.parseInt(strX);
        }
        while (true) {
            try {
                printArgumentSymbol();
                strX = userScanner.nextLine().trim();
                validator.validateCoordinatesX(strX);
                return Integer.parseInt(strX);
            } catch (NumberFormatException e) {
                System.out.println(strX + " not a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private int askCoordinatesY() {
        String strY = "";
        System.out.println("Enter Y coordinate");
        if (ConsoleClient.fileMode) {
            strY = userScanner.nextLine().trim();
            detectArgument(strY);

            strY = convertStringAsArgument(strY);
            validator.validateCoordinatesY(strY);
            ConsoleClient.printParam(strY);
            return Integer.parseInt(strY);
        }
        while (true) {
            try {
                printArgumentSymbol();
                strY = userScanner.nextLine().trim();
                validator.validateCoordinatesY(strY);
                return Integer.parseInt(strY);
            } catch (NumberFormatException e) {
                System.out.println(strY + " not a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Coordinates coordinates() {
        Integer x = askCoordinatesX();
        int y = askCoordinatesY();
        return new Coordinates(x, y);
    }

    private Long askHeight() {
        System.out.println("Enter person's height");
        String strHeight = "";
        if (ConsoleClient.fileMode) {
            strHeight = userScanner.nextLine().trim();
            detectArgument(strHeight);

            strHeight = convertStringAsArgument(strHeight);
            validator.validateHeight(strHeight);
            ConsoleClient.printParam(strHeight);
            return Long.parseLong(strHeight);

        }
        while (true) {
            try {
                printArgumentSymbol();
                strHeight = userScanner.nextLine().trim();
                validator.validateHeight(strHeight);
                return Long.parseLong(strHeight);
            } catch (NumberFormatException e) {
                System.out.println(strHeight + " not a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private float askWeight() {
        System.out.println("Enter person's weight");
        String strWeight = "";
        if (ConsoleClient.fileMode) {
            strWeight = userScanner.nextLine().trim();
            detectArgument(strWeight);
            strWeight = convertStringAsArgument(strWeight);
            validator.validateWeight(strWeight);
            ConsoleClient.printParam(strWeight);
            return Float.parseFloat(strWeight);
        }
        while (true) {
            try {
                printArgumentSymbol();
                strWeight = userScanner.nextLine().trim();
                validator.validateWeight(strWeight);
                return Float.parseFloat(strWeight);
            } catch (NumberFormatException e) {
                System.out.println(strWeight + " not a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private EyesColor askEyesColor() {
        String strColor;
        System.out.println("Choose eyes' color.");
        if (ConsoleClient.fileMode) {
            strColor = userScanner.nextLine().trim().toUpperCase();
            detectArgument(strColor);
            strColor = convertStringAsArgument(strColor);
            ConsoleClient.printParam(strColor);
            return EyesColor.valueOf(strColor);

        }
        while (true) {
            try {
                EyesColor.showColorsList();
                printArgumentSymbol();
                strColor = userScanner.nextLine().trim().toUpperCase();
                return EyesColor.valueOf(strColor);
            } catch (IllegalArgumentException e) {
                System.out.println("Eyes color wasn't found.");
            }
        }
    }

    private HairsColor askHairColor() {
        System.out.println("Choose hairs' color.");
        String strColor;
        if (ConsoleClient.fileMode) {
            strColor = userScanner.nextLine().trim().toUpperCase();
            detectArgument(strColor);
            strColor = convertStringAsArgument(strColor);
            ConsoleClient.printParam(strColor);
            return HairsColor.valueOf(strColor);

        }
        while (true) {
            try {
                HairsColor.showColorsList();
                printArgumentSymbol();
                strColor = userScanner.nextLine().trim().toUpperCase();
                return HairsColor.valueOf(strColor);
            } catch (IllegalArgumentException e) {
                System.out.println("Hairs' color wasn't found.");
            }
        }
    }

    private Long askLocationX() {
        System.out.println("Enter Location X");
        String strX = "";
        if (ConsoleClient.fileMode) {
            strX = userScanner.nextLine().trim();
            detectArgument(strX);

            strX = convertStringAsArgument(strX);
            validator.validateLocationX(strX);
            ConsoleClient.printParam(strX);
            return Long.parseLong(strX);

        }
        while (true) {
            try {
                printArgumentSymbol();
                strX = userScanner.nextLine().trim();
                validator.validateLocationX(strX);
                return Long.parseLong(strX);
            } catch (NumberFormatException e) {
                System.out.println(strX + " not a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer askLocationY() {
        System.out.println("Enter Location Y");
        String strY = "";
        if (ConsoleClient.fileMode) {
            strY = userScanner.nextLine().trim();
            detectArgument(strY);
            strY = convertStringAsArgument(strY);
            if (strY.isEmpty()) {
                ConsoleClient.printParam(strY);
                return null;
            }
            ConsoleClient.printParam(strY);
            return Integer.parseInt(strY);

        }
        while (true) {
            try {
                printArgumentSymbol();
                strY = userScanner.nextLine().trim();
                if (strY.isEmpty()) {
                    return null;
                }
                return Integer.parseInt(strY);
            } catch (NumberFormatException e) {
                System.out.println(strY + " not a number");
            }
        }
    }

    private Float askLocationZ() {
        System.out.println("Enter Location Z");
        String strZ = "";
        if (ConsoleClient.fileMode) {
            strZ = userScanner.nextLine().trim();
            detectArgument(strZ);
            strZ = convertStringAsArgument(strZ);
            validator.validateLocationZ(strZ);
            ConsoleClient.printParam(strZ);
            return Float.parseFloat(strZ);
        }
        while (true) {
            try {
                printArgumentSymbol();
                strZ = userScanner.nextLine().trim();
                validator.validateLocationZ(strZ);
                return Float.parseFloat(strZ);
            } catch (NumberFormatException e) {
                System.out.println(strZ + " not a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String askLocationName() {
        System.out.println("Enter Location's name");
        String name;
        if (ConsoleClient.fileMode) {
            name = userScanner.nextLine().trim();
            detectArgument(name);
            name = convertStringAsArgument(name);
            validator.validateName(name);
            ConsoleClient.printParam(name);
            return name;

        }
        while (true) {
            printArgumentSymbol();
            name = userScanner.nextLine().trim();
            try {
                validator.validateName(name);
                return name;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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

        try {
            if (UpdateCommand.Fields.valueOf(param.toUpperCase(Locale.ROOT)).equals(UpdateCommand.Fields.NAME)) {
                String name = askPersonName();
                personToUpdate.setName(name);
            }
            if (UpdateCommand.Fields.valueOf(param.toUpperCase(Locale.ROOT)).equals(UpdateCommand.Fields.COORDINATES)) {
                personToUpdate.setCoordinates(coordinates());
            }
            if (UpdateCommand.Fields.valueOf(param.toUpperCase(Locale.ROOT)).equals(UpdateCommand.Fields.HEIGHT)) {
                personToUpdate.setHeight(askHeight());
            }
            if (UpdateCommand.Fields.valueOf(param.toUpperCase(Locale.ROOT)).equals(UpdateCommand.Fields.WEIGHT)) {
                personToUpdate.setWeight(askWeight());
            }
            if (UpdateCommand.Fields.valueOf(param.toUpperCase(Locale.ROOT)).equals(UpdateCommand.Fields.HAIRSCOLOR)) {
                personToUpdate.setHairsColor(askHairColor());
            }
            if (UpdateCommand.Fields.valueOf(param.toUpperCase(Locale.ROOT)).equals(UpdateCommand.Fields.LOCATION)) {
                personToUpdate.setLocation(location());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong field, please try one more time");
        }
    }


}


