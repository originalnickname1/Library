package db.entity;

public class LibraryCard extends Entity{

    private double fine;
    private Integer users_id;

    public Integer getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Integer users_id) {
        this.users_id = users_id;
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
                ", users_id=" + users_id +
                '}';
    }
}
