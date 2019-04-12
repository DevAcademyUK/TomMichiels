package data;

import java.util.Scanner;

//the screen employees will see when logging in

class EmployeeSession extends UserSession {

    /*For convenience's sake, I'm using an array of strings when passing the employee details around.
    I will number the indices here to help avoid confusion.
    0 - title
    1 - forename
    2 - surname
    3 - dob
    4 - address1
    5 - towncity
    6 - county
    7 - postcode
    8 - contactno
    9 - email
    10 - id
    11 - position
    12 - startdate
     */

    //as employees can only view or edit their own object, stores it here to prevent accessing database every time
    Employee employee;


    @Override
    boolean menuActions(String[] input) {

        switch (input[0]) {
            case "1":
                System.out.println();
                System.out.println("----------");
                System.out.println(employee.stringifySelectedDetails(13));
                System.out.println("----------");
                break;
            case "2":
                editMenu(employee);
                break;
            case "3":
                return false;
            default:
                System.out.println("Input not recognised.");
        }

        return true;

    }

    //provides the employee's more limited options list (compared to the hr/manager options provided in UserSession
    @Override
    String[] menuOptions() {

        System.out.println();
        System.out.println("----------");
        System.out.println("What would you like to do today?");
        System.out.println("1 - View personal details");
        System.out.println("2 - Edit personal details");
        System.out.println("3 - Log out");

        return new String[] {myScanner.nextLine()};
    }

    EmployeeSession(String userId, Database db) {
        this.userId = userId;
        this.db = db;
        //fetches employee object from database once on session start, and stores it for all future access
        employee = db.getEmployeeById(userId);
        String[] details = employee.getDetails();
        //uses fetched employee object to find user's full name, to greet them with at start of session
        System.out.println("Welcome, " + details[0] + " " +
                details[1] + " " + details[2] + ".");
    }
    
}
