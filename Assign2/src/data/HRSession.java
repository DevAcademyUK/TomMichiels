package data;

class HRSession extends UserSession {

    @Override
    void menuActions(String[] input) {

        boolean loopMenu = true;

        switch (input[0]) {

            case "1":
                Employee employeeToView = selectEmployee();
                if (employeeToView != null) {
                    printFullDetails(employeeToView.getDetails());
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
        System.out.println("1 - View employee details");
        System.out.println("2 - Edit employee details");
        System.out.println("3 - Add new employee");
        System.out.println("4 - Log out");

        return new String[] {myScanner.nextLine()};

    }

    HRSession(String userId, Database db) {
        this.userId = userId;
        this.db = db;

        String[] details = db.getEmployeeById(userId).getDetails();
        System.out.println("Welcome, " + details[0] + " " +
                details[1] + " " + details[2] + ".");
    }
    
}
