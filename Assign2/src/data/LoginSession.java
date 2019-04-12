package data;

import java.util.ArrayList;

class LoginSession extends UserSession {

    private ArrayList<UserLogin> loginDetails;

    //handles the parsing and acting on input data
    @Override
    boolean menuActions(String[] input) {

        for (UserLogin login: loginDetails) {

            if (login.checkDetails(input)) {

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

                //escapes this method before user is told their login failed
                //if they finish a session after successfully logging in
                return true;

            }

        }

        //if user reaches this point, their login failed, so let them know that
        System.out.println("Login details not recognised, returning to menu.");


        //no actual way for this menu to stop looping - this is the top level of the program
        return true;

    }

    //requests un and pw, and then passes those to menuActions
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
