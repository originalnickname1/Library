package web.command;

import db.Role;
import db.UserDao;
import db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetAllUsersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");
        String forward = CommandConstants.ERROR_JSP;
        String errorMessage = null;
        if (user == null) {
            errorMessage = CommandConstants.ACCESS_DENIED;
            session.setAttribute("errorMessage", errorMessage);
            return forward;
        }
        Role userRole = Role.getRole(user);
        if(userRole==Role.ADMIN) {
            List<User> users = UserDao.getAllUsers();
            request.setAttribute("allUsers", users);
            forward = (CommandConstants.ADMIN_GET_ALL_USERS_JSP);
            return forward;
        }else {
            errorMessage = CommandConstants.ACCESS_DENIED;
            session.setAttribute("errorMessage", errorMessage);
            return forward;
        }
    }
}
