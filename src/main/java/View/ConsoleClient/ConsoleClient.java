package View.ConsoleClient;

import Exeptions.NoSuchCommandException;
import View.ConsoleCommands.AbstractCommand;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ConsoleClient {

    LinkedHashMap<String, AbstractCommand> commands = new LinkedHashMap<>();
    static public Scanner scanner = new Scanner(System.in);
    static public boolean fileMode = false;
    private Deque<String> files = new ArrayDeque<>();
    private static Deque<Scanner> scanners = new ArrayDeque<>();

    public void addCommands(AbstractCommand[] commands) {
        for (AbstractCommand command : commands) {
            this.commands.put(command.getName(), command);
        }
    }

    public LinkedHashMap<String, AbstractCommand> getCommands() {
        return commands;
    }

    public boolean executeCommand(String command) {
        try {
            String[] userCommand = command.split(" ", 2);
            if (!commands.containsKey(userCommand[0])) {
                throw new NoSuchCommandException("No such command " + userCommand[0]);
            }
            return commands.get(userCommand[0]).execute(userCommand.length > 1 ? userCommand[1] : "");
        } catch (NoSuchCommandException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void startInteractiveMode() {
        while (true) {
            System.out.println("\nEnter the command");
            System.out.print("$ ");
            String command = scanner.nextLine().trim();
            executeCommand(command);
        }
    }

    public static void setFileMode(boolean fileMode) {
        ConsoleClient.fileMode = fileMode;
    }

    public static void setScanner(Scanner scanner) {
        ConsoleClient.scanner = scanner;
    }

    static public void printLn(String argument) {
        System.out.println(argument);
    }

    static public void printParam(String argument) {
        System.out.println("> " + argument);
    }

    public Deque<String> getFiles() {
        return files;
    }

    public static Deque<Scanner> getScanners() {
        return scanners;
    }
}
