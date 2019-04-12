package data;

class ManagerSession extends UserSession {

    private int sortOption = 10, viewOption = 13;
    private String sortOrder = "ascending";

    private String[] sortNames = new String[] {
            "Title", "Forename", "Surname", "Date of Birth",
            "First Address Line", "Town/City", "County", "Postcode",
            "Phone Number", "Email Address", "ID", "Company Position",
            "Start Date at Company"
    };

    private String[] viewNames = new String[] {
            "Titles only", "Forenames only", "Surnames only", "Date of Birth only",
            "First line of Address only", "Town/City only", "County only", "Postcode only",
            "Phone Numbers only", "Emails only", "IDs only", "Positions only", "Start dates only",
            "All data"
    };

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

    private String sortMenuOptions() {
        System.out.println();
        System.out.println("----------");
        System.out.println("Sort menu");
        System.out.println("1 - Change category to sort on (currently '" + sortNames[sortOption] + "'):");
        System.out.println("2 - Change direction to be sorted in (currently '" + sortOrder + "'):");
        System.out.println("3 - Exit the menu");

        return myScanner.nextLine();
    }

    private void sortMenu() {

        if (sortMenuActions(sortMenuOptions())) {sortMenu();}

    }

    private void viewSelectionMenu() {

        System.out.println();
        System.out.println("Options are listed in order; choose to view one type of item from this list:");

        int i = 1;
        for (String view: viewNames) {
            System.out.println(i + " - " + view);
            i++;
        }

        viewOption = Integer.parseInt(myScanner.nextLine()) - 1;

    }

    private void displayData() {
        db.sortEmployees(sortOption, sortOrder, viewOption);
    }

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

    private void viewMenu() {
        if (viewMenuActions(viewMenuOptions())) {
            viewMenu();
        }
    }

    @Override
    void menuActions(String[] input) {

        boolean loopMenu = true;

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
        System.out.println("1 - View list of all employee details");
        System.out.println("2 - Edit employee details");
        System.out.println("3 - Add new employee");
        System.out.println("4 - Log out");

        return new String[] {myScanner.nextLine()};
    }

    ManagerSession(String userId, Database db) {
        this.userId = userId;
        this.db = db;

        String[] details = db.getEmployeeById(userId).getDetails();
        System.out.println("Welcome, " + details[0] + " " +
                details[1] + " " + details[2] + ".");
    }
    
}
