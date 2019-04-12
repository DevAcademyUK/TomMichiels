package data;

import java.util.ArrayList;

//Class the program starts in

public class RecordsSystem {


    //stores the database (which holds the collection of employee objects)
    Database db;


    //boots up the login session
    private void startSystem () {
        db = new Database();
        LoginSession ls = new LoginSession(db);
        ls.menu();
    }


    //initialises program
    public static void main(String[] args) {
        RecordsSystem rs = new RecordsSystem();
        rs.startSystem();
    }

}
