package library;

public class Book {

    String title;
    String author;
    String year;
    int id;

    public String toString() {
        return "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Year: " + year + "\n" +
                "ID: " + id;
    }

    public Book (String title, String author, String year, int id) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.id = id;
    }

}
