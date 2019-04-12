package data;

//session hr employees will see. Least unique code of the three sessions, as employee has intentionally limited options,
//while manager has expanded ones

class HRSession extends UserSession {

    //calls different functions from the userSession superclass dependant on user input collected in menuoptions
    //(also in userSession superclass
    @Override
    boolean menuActions(String[] input) {

        switch (input[0]) {

            case "1":
                Employee employeeToView = selectEmployee();
                if (employeeToView != null) {
                    System.out.println();
                    System.out.println("----------");
                    System.out.println(employeeToView.stringifySelectedDetails(13));
                    System.out.println("----------");
                }
                break;
            case "2":
                Employee employeeToEdit = selectEmployee();
                if (employeeToEdit != null) {
                    editMenu(employeeToEdit);
                }
                break;
            case "3":
                addNewUser();
                break;
            case "4":
                return false;
            default:
                System.out.println("Input not recognised.");
        }

        return true;

    }

    HRSession(String userId, Database db) {
        this.userId = userId;
        this.db = db;

        //gives a greeting based on personal employee details
        String[] details = db.getEmployeeById(userId).getDetails();
        System.out.println("Welcome, " + details[0] + " " +
                details[1] + " " + details[2] + ".");
    }
    
}
