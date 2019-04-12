package data;

import java.util.ArrayList;

//Class the program starts in

public class RecordsSystem {


    //stores the database (which holds the collection of employee objects)
    Database db;


    //boots up the login session
    //TODO move the login details collection into the database to handle
    // addition of new accounts and changing of account permissions
    private void startSystem () {
        db = new Database();
        ArrayList<UserLogin> loginDetails = makeLogins();
        LoginSession ls = new LoginSession(loginDetails, db);
        ls.menu();
    }


    //list of initial login details; one for an employee, one for a hr position, and one for a hr manager
    private static ArrayList<UserLogin> makeLogins() {
        ArrayList<UserLogin> logins = new ArrayList<>();
        logins.add(new UserLogin("un1", "pw1", "employee", "1"));
        logins.add(new UserLogin("un2", "pw2", "hr", "2"));
        logins.add(new UserLogin("un3", "pw3", "manager", "3"));

        return logins;
    }


    //initialises program
    public static void main(String[] args) {
        RecordsSystem rs = new RecordsSystem();
        rs.startSystem();
    }

}
