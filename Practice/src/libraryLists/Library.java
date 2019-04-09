package libraryLists;

import java.util.*;

public class Library {

    private Scanner myScanner = new Scanner(System.in);

    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    private int bookId = 1, memberId = 1;

    private boolean checkBookExists (String title) {
        boolean checkExists = false;

        for (Book book: books) {
            if (book.title.equalsIgnoreCase(title)) {
                checkExists = true;
            }
        }

        return checkExists;
    }

    private Book searchBookById(int bookId) {
        for (Book book: books) {
            if (book.id == bookId) {
                return book;
            }
        }

        return null;
    }

    private void searchBook() {

        boolean exists = false;

        System.out.println("Please enter book title: ");
        String title = myScanner.nextLine();

        for (Book book: books) {
            if (book.title.equalsIgnoreCase(title)) {
                exists = true;
                System.out.println("Book '" + book.title + "' exists in our system.");
            }
        }

        if (!exists) {
            System.out.println("Book '" + title + "' does not exist in our system.");
        }

        menu();

    }

    private void searchAuthor() {

        List<String> titles = new ArrayList<>();

        System.out.println("Please insert author name (both forename and surname):");
        String authorIn = myScanner.nextLine();

        for (Book book: books) {
            if (authorIn.equalsIgnoreCase(book.author)) {
                titles.add(book.title);
            }
        }

        if (titles.size() > 0) {
            System.out.println("We found these titles by " + authorIn + ":");
            for (String title: titles) {
                System.out.println("'" + title + "'");
            }
        } else {
            System.out.println("We do not have any books by " + authorIn + " in our system.");
        }

        menu();

    }

    private int getBookId(String title) {

        for (Book book: books) {
            if (title.equalsIgnoreCase(book.title)) {
                return book.id;
            }
        }

        return 0;

    }

    private int getMemberId(String forename, String surname) {

        for (Member member: members) {
            if (forename.equalsIgnoreCase(member.forename) &&
                surname.equalsIgnoreCase(member.surname)) {
                return member.id;
            }
        }

        return 0;

    }

    private void checkAvailability() {

        System.out.println("Which book would you like to check on?");
        String title = myScanner.nextLine();
        boolean loaned = false;

        for (Loan loan: loans) {
            Book book = searchBookById (loan.bookId);
            if (book != null && title.equalsIgnoreCase(book.title)) {
                loaned = true;
                System.out.println("Unfortunately, " + book.title + " is being loaned out currently.");
                break;
            }
        }

        if (!loaned) {
            if (checkBookExists(title)) {
                System.out.println("We couldn't find that book in our loans record, " +
                        "so it is free for collection!");
            } else {
                System.out.println("I'm afraid we don't recognise '" + title + "'.");
            }
        }

        menu();

    }

    private void listItems(List items) {

        for (Object item: items) {
            System.out.println(item.toString());
            System.out.println();
        }

    }

    private String[] stringifyLoan (Loan loan) {
        String[] details = new String[2];

        for (Book book: books) {
            if (book.id == loan.bookId) {
                details[0] = book.title;
            }
        }

        for (Member member: members) {
            if (member.id == loan.memberId) {
                details[1] = member.forename + " " + member.surname;
            }
        }

        return details;

    }

    private void menu() {

        System.out.println ("Welcome to the Library.");
        System.out.println ("Please enter the numerical key for one of the following options:");
        System.out.println("1 - Search for a book;");
        System.out.println("2 - Check if a book is available;");
        System.out.println("3 - Search for all books by an author;");
        System.out.println("4 - View all books;");
        System.out.println("5 - View all members;");
        System.out.println("6 - View all ongoing loans.");

        int choice = Integer.parseInt(myScanner.nextLine());

        switch (choice) {
            case 1:
                searchBook();
                break;
            case 2:
                checkAvailability();
                break;
            case 3:
                searchAuthor();
                break;
            case 4:

                System.out.println("In what order would you like to view the books?");
                System.out.println("1 - Title A-Z;");
                System.out.println("2 - Author A-Z;");
                System.out.println("3 - Year of release.");
                choice = Integer.parseInt(myScanner.nextLine());

                switch (choice) {
                    case 1:
                        Collections.sort(books);
                        break;
                    case 2:
                        books.sort(Book.bookAuthorComparator);
                        break;
                    case 3:
                        books.sort(Book.bookYearComparator);
                        break;
                    default:
                        System.out.println("Unrecognised option. Sorting by year.");
                        books.sort(Book.bookYearComparator);
                        break;
                }

                listItems(books);

                break;
            case 5:

                System.out.println("In what order would you like to view the members?");
                System.out.println("1 - Forename A-Z;");
                System.out.println("2 - Surname A-Z;");
                System.out.println("3 - Age.");
                choice = Integer.parseInt(myScanner.nextLine());

                switch (choice) {
                    case 1:
                        members.sort(Member.memberForenameComparator);
                        break;
                    case 2:
                        members.sort(Member.memberSurnameComparator);
                        break;
                    case 3:
                        members.sort(Member.memberAgeComparator);
                        break;
                    default:
                        System.out.println("Unrecognised option. Sorting by surname.");
                        Collections.sort(members);
                        break;
                }

                listItems(members);

                break;
            case 6:

                for (Loan loan: loans) {

                    String[] loanDetails = stringifyLoan(loan);

                    System.out.println("Book: '" + loanDetails[0] + "',");
                    System.out.println("Loaned by: " + loanDetails[1]);
                    System.out.println();
                }

                break;
            default:
                System.out.println("Invalid option.");
        }

        menu();

    }

    private void addWildbow() {

        books.add(new Book("Worm", "Wildbow", "2013", bookId));
        bookId++;
        books.add(new Book("Pact", "Wildbow", "2015", bookId));
        bookId++;
        books.add(new Book("Twig", "Wildbow", "2018", bookId));
        bookId++;
        books.add(new Book("Ward", "Wildbow", "2021", bookId));
        bookId++;

    }

    private void addClassics() {

        books.add(new Book("In Search of Lost Time", "Marcel Proust", "1913", bookId));
        bookId++;
        books.add(new Book("Ulysses", "James Joyce", "1922", bookId));
        bookId++;
        books.add(new Book("Moby Dick", "Herman Melville", "1851", bookId));
        bookId++;
        books.add(new Book("Pride and Prejudice", "Jane Austen", "1813", bookId));
        bookId++;
        books.add(new Book("The Canterbury Tales", "Geoffrey Chaucer", "1387", bookId));
        bookId++;

    }

    private void addMembers() {

        members.add(new Member(memberId, "Dean", "Lewis", (byte) 30));
        memberId++;
        members.add(new Member(memberId, "Steve", "Beckwith", (byte) 55));
        memberId++;
        members.add(new Member(memberId, "Lisa", "Crow", (byte) 39));
        memberId++;
        members.add(new Member(memberId, "Vicky", "Cross", (byte) 37));
        memberId++;
        members.add(new Member(memberId, "Rachel", "Alsop", (byte) 25));
        memberId++;

    }

    private void addLoans() {
        loans.add(new Loan(getBookId("Ulysses"), getMemberId("Vicky", "Cross")));
        loans.add(new Loan(getBookId("The Canterbury Tales"), getMemberId("Steve", "Beckwith")));
    }

    private void populate() {

        addClassics();
        addWildbow();
        addMembers();
        addLoans();

        members.add(new Member(memberId, "Tom", "Michiels", (byte)24));
        memberId++;

        loans.add(new Loan(getBookId("Ward"), getMemberId("Tom", "Michiels")));

    }

    private void test() {
        populate();

        menu();
    }

    public static void main(String[] args) {
        Library myLibrary = new Library();
        myLibrary.test();
    }

}
