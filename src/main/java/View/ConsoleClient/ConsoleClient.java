package View.ConsoleClient;

import View.ConsoleCommands.AbstractCommand;

import java.util.ArrayList;

public class ConsoleClient {

    AbstractCommand[] commands;

    public ConsoleClient(AbstractCommand[] commands) {
        this.commands = commands;
    }


    static public void printLn(String argument){
        System.out.println(argument);
    }
//
//    public void help(String argument){
//        if ()
//    }
}
