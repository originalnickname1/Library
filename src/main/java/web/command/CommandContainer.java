package web.command;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {
    private static final Logger log = LogManager.getLogger(CommandContainer.class);

    private static Map<String, Command> commands = new TreeMap<>();

    static{
        //common commands
        commands.put("login", new LoginCommand());
        commands.put("register", new RegisterCommand());
        commands.put("noSuchCommand", new NoSuchCommand());
        commands.put("toIndexJsp", new ToIndexJspPageCommand());
        commands.put("toRegisterJsp",new ToRegisterPageCommand());

        //admin commands
        commands.put("admin?getAllUsers", new GetAllUsersCommand());
        commands.put("admin?showUserInfo",new ShowUserInfo());
        commands.put("admin?editUser",new EditUserCommand());
        commands.put("admin?deleteUser",new DeleteUserCommand());
        commands.put("admin?updateBook", new EditBookCommand());
        commands.put("admin?createBook", new CreateBookCommand());
        commands.put("admin?deleteBook",new DeleteBookCommand());

        //librarian commands
        commands.put("librarian?getAllOrders", new GetAllOrdersCommand());
        commands.put("librarian?editOrder",new EditOrderCommand());

        //user commands
        commands.put("user?createOrder",new CreateOrderCommand());
        commands.put("showOrdersById",new ShowOrdersByUserIdCommand());
        commands.put("showOrderInfo",new ShowOrderInfo());
        commands.put("showProfile",new ShowProfileCommand());
        commands.put("user?editProfile",new EditProfileCommand());
        commands.put("user?payFine",new PayFineCommand());

        //universal commands
        commands.put("getAllBooks",new GetAllBooksCommand());
        commands.put("showBookInfo",new ShowBookInfoCommand());
        commands.put("logout",new LogoutCommand());
        commands.put("sortByTitle",new SortBooksByTitleCommand());
        commands.put("sortByAuthor",new SortBooksByAuthorCommand());
        commands.put("sortByEdition",new SortBooksByEditionCommand());
        commands.put("sortByYear",new SortBooksByYearCommand());
        commands.put("findBook",new FindBookCommand());
        commands.put("toMainPage",new ToMainPageCommand());
    }

    public static Command get(String commandName){
        if(commandName == null || !commands.containsKey(commandName)){
            log.trace("Command not found: " + commandName);
            return commands.get("noSuchCommand");
        }

        return commands.get(commandName);
    }

}
