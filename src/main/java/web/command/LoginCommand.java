package web.command;


import db.Role;
import db.UserDao;
import db.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private static final Logger log = LogManager.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        String errorMessage = null;
        String forward = CommandConstants.ERROR_JSP;

        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            errorMessage = "Login/password cannot be empty";
            session.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage" + errorMessage);
            return forward;
        }
        User user = UserDao.findUserByLogin(login);
        log.trace("User " + login +  " logged into a system.");

        if(user == null || !password.equals(user.getPassword())){
            errorMessage = "No user with such login/password";
            session.setAttribute("errorMessage", errorMessage);
            return forward;
        }else {
            Role userRole = Role.getRole(user);
            Integer userRoleId = user.getRoleId();
            forward = CommandConstants.GREETING_PAGE;
            session.setAttribute("loggedUser",user);
            session.setAttribute("loggedUserBlocked",user.getBlocked());
            System.out.println("user.getBlocked() ==> " + user.getBlocked());
        }
        return forward;
    }
}
