package db;

public final class SQLFields {
    //entities
    public static final String ENTITY_ID = "id";
    public static final String ENTITY_LOGIN = "login";
    public static final String ENTITY_PASSWORD = "password";
    public static final String ENTITY_FIRST_NAME = "first_name";
    public static final String ENTITY_LAST_NAME = "last_name";
    public static final String ENTITY_BLOCKED = "blocked";
    public static final String ENTITY_ROLES_ID = "roles_id";
    public static final String ENTITY_LIBRARY_CARD_ID = "library_card_id";
    //queries
    public static final String SQL_CREATE_USER =
            "insert into users (login,password,first_name,last_name,roles_id) values ( ?, ?, ?, ?, ? );";

}
