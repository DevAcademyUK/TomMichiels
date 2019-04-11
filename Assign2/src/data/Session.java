package data;

import java.util.Scanner;

class Session {

    static Scanner myScanner = new Scanner (System.in);
    Database db;

    void menuActions(String[] input) {

    }

    String[] menuOptions() {
        return new String[]{""};
    }

    void menu() {
        menuActions(menuOptions());
    }

}
