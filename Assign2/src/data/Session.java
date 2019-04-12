package data;

import java.util.Scanner;

//superclass for all session classes
class Session {

    //defines a single static scanner to handle all inputs throughout the program
    static Scanner myScanner = new Scanner (System.in);

    //defines that all sessions hold the database object
    Database db;

    //method that handles switching on the inputs provided and returns true to loop, or false to exit the menu
    boolean menuActions(String[] input) { return true; }

    //method that asks for options and returns the users inputs in an array of strings
    String[] menuOptions() { return new String[]{""}; }

    //defines a basic structure for a looping menu
    void menu() { if(menuActions(menuOptions())) { menu(); } }

}
