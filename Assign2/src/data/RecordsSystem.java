package data;

import java.util.ArrayList;

public class RecordsSystem {

    Database db;

    private void startSystem () {
        db = new Database();
        ArrayList<UserLogin> loginDetails = makeLogins();
        LoginSession ls = new LoginSession(loginDetails, db);
        ls.menu();
    }

    private static ArrayList<UserLogin> makeLogins() {
        ArrayList<UserLogin> logins = new ArrayList<>();
        logins.add(new UserLogin("un1", "pw1", "employee", "1"));
        logins.add(new UserLogin("un2", "pw2", "hr", "2"));
        logins.add(new UserLogin("un3", "pw3", "manager", "3"));

        return logins;
    }

    public static void main(String[] args) {
        RecordsSystem rs = new RecordsSystem();
        rs.startSystem();
    }

}
