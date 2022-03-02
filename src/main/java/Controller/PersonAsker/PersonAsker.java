package Controller.PersonAsker;

import Controller.validators.PersonValidator;
import Model.Coordinates;
import Model.EyesColor;
import Model.HairsColor;

import java.util.Scanner;

public class PersonAsker {

    private final Scanner userScanner;
    private final PersonValidator validator = new PersonValidator();

    public PersonAsker(Scanner userScanner) {
        this.userScanner = userScanner;
    }


    private String askName() {
        String name;
        while (true) {
            try {
                System.out.println("Enter person's name");
                name = userScanner.next().trim();
                validator.validateName(name);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }

    private Integer askX() {
        String strX;
        Integer x;
        while (true) {
            try {
                System.out.println("Enter X coordinate");
                strX = userScanner.next().trim();
                validator.validateCoordinatesX(strX);
                x = Integer.parseInt(strX);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return x;
    }


    private int askY() {
        String strY;
        int y;
        while (true) {
            try {
                System.out.println("Enter X coordinate");
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
        Integer x = askX();
        int y = askY();
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

//    private HairsColor askHairColor(){
//
//    }

}
