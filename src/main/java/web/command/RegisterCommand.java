package web.command;

import db.Role;
import db.UserDao;
import db.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand implements Command {

    private static final Logger log = LogManager.getLogger(RegisterCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        User user;
        String errorMessage = null;
        String forward = "/jsp/error.jsp";

        if (login == null || password == null || firstName == null || lastName == null ||
                login.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            errorMessage = "All fields must be filled";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage" + errorMessage);
            return forward;
        }
        new UserDao().createUser(login,password,firstName,lastName,3);
        user = UserDao.findUserByLogin(login);
        System.out.println("user in register command after create and find = " + user);
        log.trace("User " + login +  " created in a system.");

        if(user == null){
            errorMessage = "Failed to create user";
            request.setAttribute("errorMessage", errorMessage);
            return forward;
        }else {
            Role userRole = Role.getRole(user);

            /**
             * Methods are not finished
             */
            if (userRole == Role.ADMIN) {
                forward = "admin.jsp";
            }
            if (userRole == Role.LIBRARIAN) {
                forward = "librarian.jsp";
            }
            if (userRole == Role.USER) {
                forward = "jsp/greeting_page.jsp";
            }
            session.setAttribute("loggedUser",login);
            session.setAttribute("userRole", userRole);
        }
        return forward;
    }
}