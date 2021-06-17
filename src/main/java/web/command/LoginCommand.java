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
        User user = new UserDao().findUserByLogin(login);
        log.trace("User " + login +  " logged into a system.");

        if(user == null || !password.equals(user.getPassword())){
            errorMessage = "No user with such login/password";
            session.setAttribute("errorMessage", errorMessage);
            return forward;
        }else {
            Role userRole = Role.getRole(user);
            Integer userRoleId = user.getRoleId();

            if (userRole == Role.ADMIN) {
                forward = "jsp/admin/admin_menu.jsp";
            }
            if (userRole == Role.LIBRARIAN) {
                forward = "/jsp/librarian/librarian_menu.jsp";
            }
            if (userRole == Role.USER) {
                forward = "jsp/greeting_page.jsp";
            }
            Integer userId = user.getId();
            session.setAttribute("userRoleId",userRoleId);
            session.setAttribute(CommandConstants.USER_LOGGED_USER_ATTRIBUTE,login);
            session.setAttribute(CommandConstants.USER_ROLE_ATTRIBUTE, userRole);
            System.out.println("userRole ==> " + userRole);
            session.setAttribute("loggedUserBlocked",user.getBlocked());
            System.out.println("user.getBlocked() ==> " + user.getBlocked());
            session.setAttribute("userId",userId);
        }
        return forward;
    }
}
