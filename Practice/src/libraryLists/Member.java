package libraryLists;

import java.util.Comparator;

public class Member implements Comparable<Member> {

    int id;
    String forename;
    String surname;
    private byte age;

    public String toString() {
        return "Name: " + forename + " " + surname + "\n" +
                "Age: " + age;
    }

    static Comparator<Member> memberForenameComparator;

    static {
        memberForenameComparator = Comparator.comparing(m -> m.forename);
    }

    static Comparator<Member> memberSurnameComparator;

    static {
        memberSurnameComparator = Comparator.comparing(m -> m.surname);
    }

    static Comparator<Member> memberAgeComparator;

    static {
        memberAgeComparator = Comparator.comparing(m -> m.age);
    }

    @Override
    public int compareTo (Member o) {

        return surname.compareTo(o.surname);

    }

    Member(int id, String forename, String surname, byte age) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.age = age;
    }

}
