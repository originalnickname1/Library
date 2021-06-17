package db.entity;

public class Book extends Entity{

    private String title;
    private Integer yearOfPublish;
    private String author;
    private String publisher;
    private Integer amount;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(Integer yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", yearOfPublish=" + yearOfPublish +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
