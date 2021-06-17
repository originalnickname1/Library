package db.entity;

public class Order extends Entity{
    private String  status;
    private String type;
    private Integer libraryCardId;
    private String timeBookTaken;
    private String timeBookShouldBeReturned;
    private Integer bookId;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLibraryCardId() {
        return libraryCardId;
    }

    public void setLibraryCardId(Integer libraryCardId) {
        this.libraryCardId = libraryCardId;
    }

    public String getTimeBookTaken() {
        return timeBookTaken;
    }

    public void setTimeBookTaken(String timeBookTaken) {
        this.timeBookTaken = timeBookTaken;
    }

    public String getTimeBookShouldBeReturned() {
        return timeBookShouldBeReturned;
    }

    public void setTimeBookShouldBeReturned(String timeBookShouldBeReturned) {
        this.timeBookShouldBeReturned = timeBookShouldBeReturned;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }


}
