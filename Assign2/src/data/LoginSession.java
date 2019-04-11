package data;

import java.util.ArrayList;

class LoginSession extends UserSession {

    private ArrayList<UserLogin> loginDetails;

    @Override
    void menuActions(String[] input) { 

        boolean successfulLogin = false;

        for (UserLogin login: loginDetails) {

            if (login.checkDetails(input)) {

                successfulLogin = true;

                switch (login.getType()) {
                    case "employee":
                        EmployeeSession es = new EmployeeSession(login.getId(), db);
                        es.menu();
                        break;
                    case "hr":
                        HRSession hs = new HRSession(login.getId(), db);
                        hs.menu();
                        break;
                    case "manager":
                        ManagerSession ms = new ManagerSession(login.getId(), db);
                        ms.menu();
                        break;
                }

            }

        }

        if (!successfulLogin) {
            System.out.println("Login details not recognised, returning to menu.");
        }

        menu();

    }

    @Override
    String[] menuOptions() {

        String[] input = new String[2];

        //TODO allow new users to choose login details if they have been added to the employee list

        System.out.println();
        System.out.println("----------");
        System.out.println("Welcome to the employee records. Please enter your login details.");
        System.out.println("Username:");
        input[0] = Session.myScanner.nextLine();
        System.out.println("Password:");
        input[1] = Session.myScanner.nextLine();

        return input;

    }

    LoginSession(ArrayList<UserLogin> loginDetails, Database db) {
        this.loginDetails = loginDetails;
        this.db = db;
    }

}
