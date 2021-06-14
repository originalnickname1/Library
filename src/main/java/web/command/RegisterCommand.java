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

        String errorMessage = null;
        String forward = "/jsp/error.jsp";

        if (login == null || password == null || firstName == null || lastName == null ||
                login.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            errorMessage = "All fields must be filled";
            session.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage" + errorMessage);
            return forward;
        }

        User user = UserDao.findUserByLogin(login);

        if (user != null) {
            if (user.getLogin().equals(login)) {
                errorMessage = "User with such login is already exists!";
                session.setAttribute("errorMessage", errorMessage);
                return forward;
            }
        }

        UserDao.createUser(login, password, firstName, lastName, 3);
        user = UserDao.findUserByLogin(login);
        System.out.println("user in register command after create and find = " + user);
        log.trace("User " + login + " created in a system.");

        if (user == null) {
            errorMessage = "Failed to create user";
            session.setAttribute("errorMessage", errorMessage); //?request.setAttribute??
            return forward;
        } else {
            Role userRole = Role.getRole(user);
            if (userRole == Role.USER) {
                forward = "jsp/greeting_page.jsp";
            }
            session.setAttribute(CommandConstants.USER_LOGGED_USER_ATTRIBUTE, login);
            session.setAttribute(CommandConstants.USER_ROLE_ATTRIBUTE, userRole);
        }
        return forward;
    }
}