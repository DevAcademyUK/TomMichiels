package data;

import java.util.ArrayList;
import java.util.Comparator;

class Database {

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

    private ArrayList<Employee> employees = new ArrayList<>();
    private int idCount = 1;

    private void descendSort(int sortOption) {

        switch (sortOption) {
            case 0:
                employees.sort(Employee.employeeTitleComparator.reversed());
                break;
            case 1:
                employees.sort(Employee.employeeForenameComparator.reversed());
                break;
            case 2:
                employees.sort(Employee.employeeSurnameComparator.reversed());
                break;
            case 3:
                employees.sort(Employee.employeeDoBComparator.reversed());
                break;
            case 4:
                employees.sort(Employee.employeeAddComparator.reversed());
                break;
            case 5:
                employees.sort(Employee.employeeCityComparator.reversed());
                break;
            case 6:
                employees.sort(Employee.employeeCountyComparator.reversed());
                break;
            case 7:
                employees.sort(Employee.employeePostcodeComparator.reversed());
                break;
            case 8:
                employees.sort(Employee.employeePhoneComparator.reversed());
                break;
            case 9:
                employees.sort(Employee.employeeEmailComparator.reversed());
                break;
            case 10:
                employees.sort(Employee.employeeIdComparator.reversed());
                break;
            case 11:
                employees.sort(Employee.employeePositionComparator.reversed());
                break;
            case 12:
                employees.sort(Employee.employeeStartdateComparator.reversed());
                break;
            default:
                System.out.println("Error with sort option selected, speak to IT.");
        }

    }

    private void ascendSort(int sortOption) {

        switch (sortOption) {
            case 0:
                employees.sort(Employee.employeeTitleComparator);
                break;
            case 1:
                employees.sort(Employee.employeeForenameComparator);
                break;
            case 2:
                employees.sort(Employee.employeeSurnameComparator);
                break;
            case 3:
                employees.sort(Employee.employeeDoBComparator);
                break;
            case 4:
                employees.sort(Employee.employeeAddComparator);
                break;
            case 5:
                employees.sort(Employee.employeeCityComparator);
                break;
            case 6:
                employees.sort(Employee.employeeCountyComparator);
                break;
            case 7:
                employees.sort(Employee.employeePostcodeComparator);
                break;
            case 8:
                employees.sort(Employee.employeePhoneComparator);
                break;
            case 9:
                employees.sort(Employee.employeeEmailComparator);
                break;
            case 10:
                employees.sort(Employee.employeeIdComparator);
                break;
            case 11:
                employees.sort(Employee.employeePositionComparator);
                break;
            case 12:
                employees.sort(Employee.employeeStartdateComparator);
                break;
            default:
                System.out.println("Error with sort option selected, speak to IT.");
        }

    }

    private void displayEmployees (int viewOption) {

        System.out.println();

        System.out.println("------------");

        for (Employee employee: employees) {
            System.out.println(employee.stringifySelectedDetails(viewOption));
        }

        System.out.println("------------");
    }

    void sortEmployees(int sortOption, String sortOrder, int viewOption) {
        if (sortOrder.equals("descending")) {
            descendSort(sortOption);
        } else {
            ascendSort(sortOption);
        }

        displayEmployees(viewOption);
    }

    Employee getEmployeeById (String id) {

        for (Employee employee: employees) {

            if (employee.getDetails()[10].equals(id)) {
                return employee;
            }

        }

        return null;

    }

    String getEmployeeTypeById (String id) {

        for (Employee employee: employees) {

            if (employee.getDetails()[10].equals(id)) {
                return employee.getDetails()[11].toLowerCase();
            }

        }

        return null;

    }

    void addNewEmployee(String[] newDetails) {

        newDetails[10] = Integer.toString(idCount);
        idCount++;

        employees.add(new Employee(newDetails));

    }

    private void populate() {

        String[] emp1 = new String[]{"Mr", "John", "Smith", "2000/01/01", "1 Example Street", "City", "County",
                "AB1234", "01234567890", "jsmith@email.com", Integer.toString(idCount), "Employee", "2020/01/01"};
        idCount++;
        String[] hr1 = new String[]{"Mrs", "Jane", "Doe", "2000/01/05", "1 Example Street", "City", "County",
                "AB1234", "01234567890", "jdoe@email.com", Integer.toString(idCount), "HR", "2020/01/01"};
        idCount++;
        String[] man1 = new String[]{"Ms", "Jo", "Bloggs", "2000/01/03", "1 Example Street", "City", "County",
                "AB1234", "01234567890", "jbloggs@email.com", Integer.toString(idCount), "Manager", "2020/01/01"};
        idCount++;

        employees.add(new Employee(emp1));
        employees.add(new Employee(hr1));
        employees.add(new Employee(man1));

    }

    Database() {
        populate();
    }

}
