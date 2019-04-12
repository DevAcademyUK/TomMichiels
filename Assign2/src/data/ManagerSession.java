package data;

//session manager will see when they log in

class ManagerSession extends UserSession {

    //here the data for various reporting options are stored
    //sortOption and viewOption store indices used to indicate options selected
    //sortOrder simply records whether to display in ascending or descending order
    //default values display all data, sorted by ascending id

    private int sortOption = 10, viewOption = 13;
    private String sortOrder = "ascending";

    //this array stores the names of the options associated with the "sortOption" tag.
    //these are used to determine which field the user will sort employees by

    /*
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

    private String[] sortNames = new String[] {
            "Title", "Forename", "Surname", "Date of Birth",
            "First Address Line", "Town/City", "County", "Postcode",
            "Phone Number", "Email Address", "ID", "Company Position",
            "Start Date at Company"
    };

    //this array stores the names of the options associated with the "viewOption" tag.
    //these are used to determine which field the system will display

    /*
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
    13 - all of the above
     */

    private String[] viewNames = new String[] {
            "Titles only", "Forenames only", "Surnames only", "Date of Birth only",
            "First line of Address only", "Town/City only", "County only", "Postcode only",
            "Phone Numbers only", "Emails only", "IDs only", "Positions only", "Start dates only",
            "All data"
    };

    //similar to viewselection menu, displays full list of options
    private void changeSortOption() {

        System.out.println();
        System.out.println("Options are listed in order; choose to sort by one item from this list:");

        int i = 1;
        for (String name: sortNames) {
            System.out.println(i + " - " + name);
            i++;
        }

        sortOption = Integer.parseInt(myScanner.nextLine()) - 1;

    }

    //if user wants to change order, flip the variable, if they want to change field to sort on, calls next menu
    private boolean sortMenuActions(String input) {

        switch (input) {

            case "1":
                changeSortOption();
                break;
            case "2":
                if (sortOrder.equals("ascending")) {
                    sortOrder = "descending";
                } else {
                    sortOrder = "ascending";
                }
                break;
            case "3":
                return false;
            default:
                System.out.println("Input not recognised.");
        }

        return true;
    }

    //directs user based on which area of sorting they want to edit - direction or field
    private String sortMenuOptions() {
        System.out.println();
        System.out.println("----------");
        System.out.println("Sort menu");
        System.out.println("1 - Change category to sort on (currently '" + sortNames[sortOption] + "'):");
        System.out.println("2 - Change direction to be sorted in (currently '" + sortOrder + "'):");
        System.out.println("3 - Exit the menu");

        return myScanner.nextLine();
    }

    //another looping menu function similar to Session.menu(), keeps menu going until user decides to exit
    private void sortMenu() {

        if (sortMenuActions(sortMenuOptions())) {sortMenu();}

    }

    //lets user choose which field to view when data is displayed
    private void viewSelectionMenu() {

        System.out.println();
        System.out.println("Options are listed in order; choose to view one type of item from this list:");

        //when displaying options, count from 1, because managers are silly
        int i = 1;
        for (String view: viewNames) {
            System.out.println(i + " - " + view);
            i++;
        }

        //convert to counting from 0 for internal logic, because arrays aren't
        viewOption = Integer.parseInt(myScanner.nextLine()) - 1;

    }

    //calls the view method from the database object, passing all the selected options
    private void displayData() {
        db.sortEmployees(sortOption, sortOrder, viewOption);
    }

    //refers user to one of nested menus depending on option selected
    private boolean viewMenuActions(String input) {

        switch (input) {

            case "1":
                sortMenu();
                break;
            case "2":
                viewSelectionMenu();
                break;
            case "3":
                displayData();
                break;
            case "4":
                return false;
            default:
                System.out.println("Input not recognised.");

        }

        return true;

    }

    //top level options for view menu - shows currently selected sorting and viewing options,
    // and allows user to change either or display with selected options
    private String viewMenuOptions() {

        System.out.println();
        System.out.println("----------");
        System.out.println("Employee view menu");
        System.out.println("1 - Change how data should be sorted (currently by '" + sortOrder + " " + sortNames[sortOption] + "'):");
        System.out.println("2 - Change what data you want to display (currently '" + viewNames[viewOption] + "'):");
        System.out.println("3 - Display data with selected options");
        System.out.println("4 - Exit this menu");

        return myScanner.nextLine();
    }

    //top level method of the nested view menus, simply keeps it looping until they exit,
    // similar to the superclass's menu method
    private void viewMenu() {
        if (viewMenuActions(viewMenuOptions())) {
            viewMenu();
        }
    }

    //similar to the hr menuActions, except viewing data leads to a more complicated nest of menus defined above
    @Override
    boolean menuActions(String[] input) {

        switch (input[0]) {
            case "1":
                viewMenu();
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

    ManagerSession(String userId, Database db) {
        this.userId = userId;
        this.db = db;

        String[] details = db.getEmployeeById(userId).getDetails();
        System.out.println("Welcome, " + details[0] + " " +
                details[1] + " " + details[2] + ".");
    }
    
}
