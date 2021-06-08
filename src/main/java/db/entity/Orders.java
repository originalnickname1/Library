package db.entity;

public class Orders extends Entity{

    private String status;
    private String type;
    private Integer libraryCardId;

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

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + getId() + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", libraryCardId=" + libraryCardId +
                '}';
    }
}
