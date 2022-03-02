package Controller.PersonAsker;

import Controller.validators.PersonValidator;
import Model.Coordinates;

import java.util.Scanner;

public class PersonAsker {

    private final Scanner userScanner;
    private final PersonValidator validator = new PersonValidator();

    public PersonAsker(Scanner userScanner) {
        this.userScanner = userScanner;
    }


    public String askName() {
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


    public Coordinates coordinates() {
       Integer x = askX();
       int y = askY();
       return new Coordinates(x,y);
    }
}
