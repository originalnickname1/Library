package db.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LibraryCard extends Entity{

    private String timeBookTaken;
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

    public String getTimeBookTaken() {
        return timeBookTaken;
    }

    public void setTimeBookTaken(String timeBookTaken) {
        String datePattern = "dd-MM-yyyy hh:mm:ss";
        SimpleDateFormat spf = new SimpleDateFormat(datePattern);
        this.timeBookTaken = spf.format(new Date());
    }

}
