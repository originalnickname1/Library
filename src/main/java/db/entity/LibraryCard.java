package db.entity;

public class LibraryCard extends Entity{

    private double fine;
    private Integer usersId;

    public Integer getUsers_id() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "LibraryCard{" +
                "fine=" + fine +
                ", users_id=" + usersId +
                '}';
    }
}
