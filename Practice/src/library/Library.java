package library;

import java.util.Arrays;
import java.util.Scanner;

public class Library {

    Scanner myScanner = new Scanner(System.in);

    private Book[] books = new Book[0];
    private Member[] members = new Member[0];
    private Loan[] loans = new Loan[0];

    private int bookId = 1, memberId = 1;

    private Object[] addItem (Object newItem, Object[] oldArray) {

        int size = oldArray.length;
        Object[] newArray = new Object[size + 1];
        System.arraycopy(oldArray, 0, newArray, 0, size);
        newArray[size] = newItem;
        return newArray;

    }

    private void addBook (String title, String author, String year) {
        Object[] newItems;

        newItems = addItem(new Book(title, author, year, bookId), books);
        books = Arrays.copyOf(newItems, newItems.length, books.getClass());
        bookId += 1;
    }

    private void addMember (String forename, String surname, byte age) {
        Object[] newItems;

        newItems = addItem(new Member(memberId, forename, surname, age), members);
        members = Arrays.copyOf(newItems, newItems.length, members.getClass());
        memberId += 1;
    }

    private void addLoan (int bookId, int memberId) {
        Object[] newItems;

        newItems = addItem(new Loan(bookId, memberId), loans);
        loans = Arrays.copyOf(newItems, newItems.length, loans.getClass());
    }

    private int findBookId (String title) {
        for (Book book:books) {
            if (title.equalsIgnoreCase(book.title)) {
                return book.id;
            }
        }

        return 0;
    }

    private int findMemberId (String forename, String surname) {
        for (Member member: members) {
            if (forename.equalsIgnoreCase(member.forename) &&
                surname.equalsIgnoreCase(member.surname)) {
                return member.id;
            }
        }

        return 0;
    }

    private void searchBook() {

        boolean checkExists = false;

        System.out.println("Please enter book title: ");
        String title = myScanner.nextLine();

        for (Book book: books) {
            if (book.title.equalsIgnoreCase(title)) {
                checkExists = true;
                System.out.println("Yes, we have this book.");
                break;
            }
        }

        if (!checkExists) {
            System.out.println("Not in stock.");
        }

        menu();

    }

    private Book searchBookById(int bookId) {
        for (Book book: books) {
            if (book.id == bookId) {
                return book;
            }
        }

        return null;
    }

    private void searchAuthor() {

        String[] titles = new String[0];
        Object[] newTitles;

        System.out.println("Please insert author name (both forename and surname):");
        String authorIn = myScanner.nextLine();

        for (Book book: books) {
            if (authorIn.equalsIgnoreCase(book.author)) {
                newTitles = addItem(book.title, titles);
                titles = Arrays.copyOf(newTitles, newTitles.length, titles.getClass());
            }
        }

        if (titles.length > 0) {
            System.out.println("We found these titles by " + authorIn + ":");
            for (String title: titles) {
                System.out.println("'" + title + "'");
            }
        } else {
            System.out.println("We do not have any books by " + authorIn + " in our system.");
        }

        menu();

    }

    private boolean checkBookExists (String title) {
        boolean checkExists = false;

        for (Book book: books) {
            if (book.title.equalsIgnoreCase(title)) {
                checkExists = true;
            }
        }

        return checkExists;
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

    private void menu() {
        System.out.println ("Welcome to the Library.");
        System.out.println ("Please enter the numerical key for one of the following options:");
        System.out.println("1 - Search for a book;");
        System.out.println("2 - Check if a book is available;");
        System.out.println("3 - Search for all books by an author.");

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
            default:
                System.out.println("Invalid option.");
        }

    }

    private void listItems (Object[] items) {
        for (Object item: items) {
            System.out.println(item.toString());
            System.out.println();
        }
    }

    private void addWildbow() {

        addBook("Worm", "Wildbow", "2013");
        addBook("Pact", "Wildbow", "2015");
        addBook("Twig", "Wildbow", "2018");
        addBook("Ward", "Wildbow", "2021");

    }

    private void addClassics() {

        addBook("In Search of Lost Time", "Marcel Proust", "1913");
        addBook("Ulysses", "James Joyce", "1922");
        addBook("Moby Dick", "Herman Melville", "1851");
        addBook("Pride and Prejudice", "Jane Austen", "1813");
        addBook("The Canterbury Tales", "Geoffrey Chaucer", "1387");

    }

    private void addMembers() {

        addMember("Dean", "Lewis", (byte) 30);
        addMember("Steve", "Beckwith", (byte) 55);
        addMember("Lisa", "Crow", (byte) 39);
        addMember("Vicky", "Cross", (byte) 37);
        addMember("Rachel", "Alsop", (byte) 25);

    }

    private void addLoans() {

        addLoan(findBookId("Ulysses"), findMemberId("Vicky", "Cross"));
        addLoan(findBookId("The Canterbury Tales"), findMemberId("Steve", "Beckwith"));

    }

    private void populate() {

        addClassics();
        addMembers();
        addLoans();

        addWildbow();
        addMember("Tom", "Michiels", (byte)24);
        addLoan(findBookId("Ward"), findMemberId("Tom", "Michiels"));

    }

    private void test() {
        populate();
        System.out.println("Books:");
        listItems(books);
        System.out.println("Members: ");
        listItems(members);
        System.out.println("Loans: ");
        listItems(loans);

        menu();
    }

    public static void main(String[] args) {
        Library myLibrary = new Library();
        myLibrary.test();
    }

}
