package db;

import db.entity.User;

public enum Blocked {
    UNBLOCKED, BLOCKED;

    public static Blocked getBlocked(User user) {
        int roleId = user.getBlocked();
        return db.Blocked.values()[roleId];
    }

    public String getName() {
        return name().toLowerCase();
    }
}

