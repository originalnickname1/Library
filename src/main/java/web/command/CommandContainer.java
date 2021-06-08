package web.command;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {
    private static final Logger log = LogManager.getLogger(CommandContainer.class);

    private static Map<String, Command> commands = new TreeMap<>();

    static{
        commands.put("login", new LoginCommand());
        commands.put("register", new RegisterCommand());
        commands.put("greeting_page", new GreetingPageCommand());
        commands.put("noSuchCommand", new NoSuchCommand());
        commands.put("admin/getAllUsers", new GetAllUsersCommand());
    }

    public static Command get(String commandName){
        if(commandName == null || !commands.containsKey(commandName)){
            log.trace("Command not found: " + commandName);
            return commands.get("noSuchCommand");
        }

        return commands.get(commandName);
    }

}
