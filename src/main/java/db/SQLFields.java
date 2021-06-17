package db;

public final class SQLFields {
    //user
    public static final String USER_ID = "id";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_FIRST_NAME = "first_name";
    public static final String USER_LAST_NAME = "last_name";
    public static final String USER_BLOCKED = "blocked";
    public static final String USER_ROLES_ID = "roles_id";
    //book
    public static final String BOOK_ID = "id";
    public static final String BOOK_TITLE = "title";
    public static final String BOOK_YEAR_OF_PUBLISH = "year_of_publish";
    public static final String BOOK_AUTHOR = "author";
    public static final String BOOK_PUBLISHER = "publisher";
    public static final String BOOK_AMOUNT = "amount";
    public static final String BOOK_DESCRIPTION = "description";
    //order
    public static final String ORDER_ID = "id";
    public static final String ORDER_STATUS = "status";
    public static final String ORDER_TYPE = "type";
    public static final String ORDER_LIBRARY_CARD_ID = "library_cards_users_id";
    public static final String ORDER_TIME_BOOK_TAKEN = "time_book_taken";
    public static final String ORDER_TIME_BOOK_SHOULD_BE_RETURNED = "time_book_should_be_returned";
    public static final String ORDER_BOOK_ID = "books_id";



}
