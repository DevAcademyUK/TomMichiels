package data;

import java.util.Scanner;

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

    Employee employee;

    @Override
    void menuActions(String[] input) {

        boolean loopMenu = true;

        switch (input[0]) {
            case "1":
                printFullDetails(employee.getDetails());
                break;
            case "2":
                editMenu(employee);
                break;
            case "3":
                loopMenu = false;
                break;
            default:
                System.out.println("Input not recognised.");
        }

        if (loopMenu) {menu();}

    }

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
        employee = db.getEmployeeById(userId);
        String[] details = employee.getDetails();
        System.out.println("Welcome, " + details[0] + " " +
                details[1] + " " + details[2] + ".");
    }
    
}
