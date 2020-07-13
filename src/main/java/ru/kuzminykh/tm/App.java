package ru.kuzminykh.tm;

import static ru.kuzminykh.tm.constant.TerminalConst.*;

public class App {

    public static void main(final String[] args) {
        run(args);
        displayWelcome();
    }

    private static void run(final String[] args){
        if (args == null) return;
        if(args.length < 1) return;
        final String param = args[0];
        switch (param){
            case VERSION: displayVersion();
            case ABOUT: displayAbout();
            case HELP: displayHelp();
            default: displayError();
        }
     }

    private static void displayError(){
        System.out.println("Error! Unknown program argument...");
        System.exit(-1);
    }

    private static void displayWelcome(){
        System.out.println("** WELCOME TO TASK MANAGER **");
    }

    private static void displayHelp(){
        System.out.println("version - Display application version.");
        System.out.println("about - Display developer info.");
        System.out.println("help - Display list of commands.");
        System.exit(0);
    }

    private static void displayVersion(){
        System.out.println("1.0.0");
        System.exit(0);
    }

    private static void displayAbout(){
        System.out.println("NataLia Kuzmihykh");
        System.out.println("Kuzmihykh_nn@nlmk.com");
        System.exit(0);
    }

}
