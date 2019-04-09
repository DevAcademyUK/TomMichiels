package libraryLists;

import java.util.Comparator;

public class Book implements Comparable<Book>{

    String title;
    String author;
    private String year;
    int id;

    public String toString() {
        return "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Year: " + year + "\n";
    }

    @Override
    public int compareTo(Book o) {

        return title.compareTo(o.title);

    }

    static Comparator<Book> bookAuthorComparator;

    static {
        bookAuthorComparator = Comparator.comparing(b -> b.author);
    }

    static Comparator<Book> bookYearComparator;

    static {
        bookYearComparator = Comparator.comparing(b -> Integer.parseInt(b.year));
    }

    Book (String title, String author, String year, int id) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.id = id;
    }

}
