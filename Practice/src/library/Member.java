package library;

public class Member {

    int id;
    String forename;
    String surname;
    byte age;

    public String toString() {
        return "Name: " + forename + " " + surname + "\n" +
                "ID: " + id;
    }

    public Member(int id, String forename, String surname, byte age) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.age = age;
    }

}
