package libraryLists;

public class Loan {

    int bookId;
    int memberId;


    public String toString() {
       return "Member ID: " + memberId + "\n" +
               "Book ID: " + bookId;
    }

    Loan(int bookId, int memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
    }

}
