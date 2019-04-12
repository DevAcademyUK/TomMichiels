package data;

//class contains methods used by multiple types of user sessions, to prevent repeated code

class UserSession extends Session{

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

    //every session except login session needs to know who is logged in
    String userId;

    //asks for an id number and returns associated employee object, used by hr and manager
    Employee selectEmployee() {
        System.out.print("Enter ID number of employee to be accessed:");
        String id = myScanner.nextLine();
        Employee employee = db.getEmployeeById(id);

        if (employee == null) {
            System.out.println("Could not find an employee with that ID.");
        } else {
            return employee;
        }

        return null;

    }

    //handles the collection of information for a new user, used by both manager and hr
    void addNewUser() {

        if (db.getEmployeeTypeById(userId).equals("hr") || db.getEmployeeTypeById(userId).equals("manager")) {

            String[] newDetails = new String[13];

            System.out.println("Please enter new user data in order.");

            System.out.print("Title: ");
            newDetails[0] = myScanner.nextLine();

            System.out.print("Forename: ");
            newDetails[1] = myScanner.nextLine();

            System.out.print("Surname: ");
            newDetails[2] = myScanner.nextLine();

            System.out.print("Date of Birth: ");
            System.out.println("(yyyy/mm/dd)");
            newDetails[3] = myScanner.nextLine();

            System.out.print("First line of Address: ");
            newDetails[4] = myScanner.nextLine();

            System.out.print("Town or City: ");
            newDetails[5] = myScanner.nextLine();

            System.out.print("County: ");
            newDetails[6] = myScanner.nextLine();

            System.out.print("Postcode: ");
            newDetails[7] = myScanner.nextLine();

            System.out.print("Phone number: ");
            newDetails[8] = myScanner.nextLine();

            System.out.print("Email Address: ");
            newDetails[9] = myScanner.nextLine();

            System.out.print("Position at company: ");
            System.out.println("'Employee', 'HR' or 'Manager'");
            newDetails[11] = myScanner.nextLine();

            System.out.print("Start Date at company: ");
            System.out.println("(yyyy/mm/dd)");
            newDetails[12] = myScanner.nextLine();

            db.addNewEmployee(newDetails);

        } else {
            System.out.println("You don't have the permissions to create a new user. " +
                    "How did you even get this far?");
        }
    }

    //these four similar menus are the nested menus for editing different categories of employee data,
    //to help make navigating more manageable
    private void corporateMenu(Employee employee) {

        String[] details = employee.getDetails();

        System.out.println();
        System.out.println("----------");
        System.out.println("What part of these corporate details would you like to edit?");
        System.out.println("1 - Position: '" + details[11] + "'");
        System.out.println("2 - Start Date: '" + details[12] + "'");
        System.out.println("3 - Exit this menu");

        String input = myScanner.nextLine();
        boolean loopMenu = true;

        switch (input) {
            case "1":
                System.out.println("Enter new position within the company: ");
                System.out.println("(Currently accepted positions are 'employee', 'hr', and 'manager')");
                input = myScanner.nextLine();
                employee.updateField(11, input);
                break;
            case "2":
                System.out.println("Enter new start date: ");
                System.out.println("(yyyy/mm/dd)");
                input = myScanner.nextLine();
                employee.updateField(12, input);
                break;
            case "3":
                loopMenu = false;
                break;
            default:
                System.out.println("Input not recognised.");
        }

        if (loopMenu) {corporateMenu(employee);}

    }

    private void contactMenu(Employee employee) {

        String[] details = employee.getDetails();

        System.out.println();
        System.out.println("----------");
        System.out.println("What part of these contact details would you like to edit?");
        System.out.println("1 - Telephone no.: '" + details[8] + "'");
        System.out.println("2 - Email Address: '" + details[9] + "'");
        System.out.println("3 - Exit this menu");

        String input = myScanner.nextLine();
        boolean loopMenu = true;

        switch (input) {
            case "1":
                System.out.println("Enter new phone number: ");
                input = myScanner.nextLine();
                employee.updateField(8, input);
                break;
            case "2":
                System.out.println("Enter new email address: ");
                input = myScanner.nextLine();
                employee.updateField(9, input);
                break;
            case "3":
                loopMenu = false;
                break;
            default:
                System.out.println("Input not recognised.");
        }

        if (loopMenu) {contactMenu(employee);}

    }

    private void addressMenu(Employee employee) {

        String[] details = employee.getDetails();

        System.out.println();
        System.out.println("----------");
        System.out.println("What part of these address details would you like to edit?");
        System.out.println("1 - First Line of Address: '" + details[4] + "'");
        System.out.println("2 - Town/City: '" + details[5] + "'");
        System.out.println("3 - County: '" + details[6] + "'");
        System.out.println("4 - Postcode: '" + details[7] + "'");
        System.out.println("5 - Exit this menu");

        String input = myScanner.nextLine();
        boolean loopMenu = true;

        switch (input) {
            case "1":
                System.out.println("Enter the first line of the new address: ");
                input = myScanner.nextLine();
                employee.updateField(4, input);
                break;
            case "2":
                System.out.println("Enter town or city of the new address: ");
                input = myScanner.nextLine();
                employee.updateField(5, input);
                break;
            case "3":
                System.out.println("Enter county of the new address: ");
                input = myScanner.nextLine();
                employee.updateField(6, input);
                break;
            case "4":
                System.out.println("Enter postcode of the new address: ");
                input = myScanner.nextLine();
                employee.updateField(7, input);
                break;
            case "5":
                loopMenu = false;
                break;
            default:
                System.out.println("Input not recognised.");
        }

        if (loopMenu) {addressMenu(employee);}

    }

    private void personalMenu(Employee employee) {

        String[] details = employee.getDetails();

        System.out.println();
        System.out.println("----------");
        System.out.println("What part of these personal details would you like to edit?");
        System.out.println("1 - Title: '" + details[0] + "'");
        System.out.println("2 - Forename: '" + details[1] + "'");
        System.out.println("3 - Surname: '" + details[2] + "'");
        System.out.println("4 - Date of Birth: '" + details[3] + "'");
        System.out.println("5 - Exit this menu");

        String input = myScanner.nextLine();
        boolean loopMenu = true;

        switch (input) {
            case "1":
                System.out.println("Enter new title: ");
                input = myScanner.nextLine();
                employee.updateField(0, input);
                break;
            case "2":
                System.out.println("Enter new forename: ");
                input = myScanner.nextLine();
                employee.updateField(1, input);
                break;
            case "3":
                System.out.println("Enter new surname: ");
                input = myScanner.nextLine();
                employee.updateField(2, input);
                break;
            case "4":
                if (db.getEmployeeTypeById(userId).equals("employee")) {
                    System.out.println("Date of birth can only be edited by the HR department.");
                } else {
                    System.out.println("Enter new date of birth: ");
                    System.out.println("(yyyy/mm/dd)");
                    input = myScanner.nextLine();
                    employee.updateField(3, input);
                }
                break;
            case "5":
                loopMenu = false;
                break;
            default:
                System.out.println("Input not recognised.");
        }

        if (loopMenu) {personalMenu(employee);}

    }

    //handles the menu for accessing and editing different fields of passed employee object (used by all user sessions)
    void editMenu(Employee employee) {

        System.out.println();
        System.out.println("----------");
        System.out.println("What part of these details would you like to edit?");
        System.out.println("1 - Personal details");
        System.out.println("2 - Address");
        System.out.println("3 - Contact details");
        System.out.println("4 - Corporate details");
        System.out.println("5 - Exit this menu");

        String input = myScanner.nextLine();
        boolean loopMenu = true;

        switch (input) {
            case "1":
                personalMenu(employee);
                break;
            case "2":
                addressMenu(employee);
                break;
            case "3":
                contactMenu(employee);
                break;
            case "4":
                if (db.getEmployeeTypeById(userId).equals("employee")) {
                    System.out.println("Corporate details can only be edited by the HR department.");
                } else {
                    corporateMenu(employee);
                }
                break;
            case "5":
                loopMenu = false;
                break;
            default:
                System.out.println("Input not recognised.");
        }

        if (loopMenu) {editMenu(employee);}

    }

    //the menu options for both hr and manager (though manager gets more detailed actions on view)
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

}
