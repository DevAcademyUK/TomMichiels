package data;

import java.util.Comparator;

class Employee implements Comparable<Employee> {

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

    private String title, forename, surname, dob,
            address1, towncity, county, postcode,
            contactno, email, id, position, startdate;

    static Comparator<Employee> employeeTitleComparator;
    static Comparator<Employee> employeeForenameComparator;
    static Comparator<Employee> employeeSurnameComparator;
    static Comparator<Employee> employeeDoBComparator;
    static Comparator<Employee> employeeAddComparator;
    static Comparator<Employee> employeeCityComparator;
    static Comparator<Employee> employeeCountyComparator;
    static Comparator<Employee> employeePostcodeComparator;
    static Comparator<Employee> employeePhoneComparator;
    static Comparator<Employee> employeeEmailComparator;
    static Comparator<Employee> employeeIdComparator;
    static Comparator<Employee> employeePositionComparator;
    static Comparator<Employee> employeeStartdateComparator;

    static {

        employeeTitleComparator = Comparator.comparing(e -> e.title);
        employeeForenameComparator = Comparator.comparing(e -> e.forename);
        employeeSurnameComparator = Comparator.comparing(e -> e.surname);
        employeeDoBComparator = Comparator.comparing(e -> e.dob);
        employeeAddComparator = Comparator.comparing(e -> e.address1);
        employeeCityComparator = Comparator.comparing(e -> e.towncity);
        employeeCountyComparator = Comparator.comparing(e -> e.county);
        employeePostcodeComparator = Comparator.comparing(e -> e.postcode);
        employeePhoneComparator = Comparator.comparing(e -> e.contactno);
        employeeEmailComparator = Comparator.comparing(e -> e.email);
        employeeIdComparator = Comparator.comparing(e -> e.id);
        employeePositionComparator = Comparator.comparing(e -> e.position);
        employeeStartdateComparator = Comparator.comparing(e -> e.startdate);
    }

    public String stringifySelectedDetails(int option) {

        if (option == 13) {

            String catDetails = "";

            for (String detail : getDetails()) {
                catDetails = catDetails + detail;
                catDetails = catDetails + " ";
            }

            return catDetails;

        } else {

            return getDetails()[option];

        }

    }

    void updateField(int index, String newData) {

        String[] newDataSet = getDetails();
        newDataSet[index] = newData;
        assignValues(newDataSet);

    }

    String[] getDetails() {
        return new String[]{title, forename, surname, dob,
            address1, towncity, county, postcode, contactno,
            email, id, position, startdate};
    }

    void assignValues (String[] args) {
        title = args[0];
        forename = args[1];
        surname = args[2];
        dob = args[3];
        address1 = args[4];
        towncity = args[5];
        county = args[6];
        postcode = args[7];
        contactno = args[8];
        email = args[9];
        id = args[10];
        position = args[11];
        startdate = args[12];
    }

    @Override
    public int compareTo(Employee e) {

        return Integer.compare(Integer.parseInt(this.id), Integer.parseInt(e.id));

    }

    Employee(String[] args) {
        assignValues(args);
    }

}
