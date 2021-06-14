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

        //admin commands
        commands.put("admin?getAllUsers", new GetAllUsersCommand());
        commands.put("admin?showUserInfo",new ShowUserInfo());
        commands.put("admin?editUser",new EditUserCommand());
        commands.put("admin?deleteUser",new DeleteUserCommand());

        //librarian commands
        commands.put("librarian?createBook", new CreateBookCommand());

        //user commands
        commands.put("user?addBook",new AddBookToOrder());

        //universal commands
        commands.put("getAllBooks",new GetAllBooksCommand());
        commands.put("showBookInfo",new ShowBookInfoCommand());
        commands.put("logout",new LogoutCommand());
    }

    public static Command get(String commandName){
        if(commandName == null || !commands.containsKey(commandName)){
            log.trace("Command not found: " + commandName);
            return commands.get("noSuchCommand");
        }

        return commands.get(commandName);
    }

}
