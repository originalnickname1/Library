package db;

import db.entity.User;

public enum Role {
    ADMIN, LIBRARIAN, USER;

    public static Role getRole(User user){
        int roleId = user.getRoleId()-1;
        return Role.values()[roleId];
    }

    public String getName(){
        return name().toLowerCase();
    }
}
