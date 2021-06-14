package db.entity;

import java.sql.Date;

public class Orders extends Entity{
    private String status;
    private String type;
    private Integer libraryCardId;
    private Date time_book_taken;
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

    public Date getTime_book_taken() {
        return time_book_taken;
    }

    public void setTime_book_taken(Date time_book_taken) {
        this.time_book_taken = time_book_taken;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", libraryCardId=" + libraryCardId +
                ", time_book_taken=" + time_book_taken +
                ", bookId=" + bookId +
                '}';
    }
}
