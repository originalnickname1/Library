package db;

import db.entity.User;

public enum Role {
    ADMIN, LIBRARIAN, USER;

    public static final Integer DIFFERENCE = 1;

    public static Role getRole(User user){
        int roleId = user.getRoleId()-DIFFERENCE;
        return Role.values()[roleId];
    }

    public String getName(){
        return name().toLowerCase();
    }
}
