package library;

public class Loan {

    int bookId;
    int memberId;


    public String toString() {
       return "Member ID: " + memberId + "\n" +
               "Book ID: " + bookId;
    }

    public Loan(int bookId, int memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
    }

}
