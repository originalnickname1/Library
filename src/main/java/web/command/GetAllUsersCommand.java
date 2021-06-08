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
        Role userRole = (Role) session.getAttribute("userRole");
        String forward = "jsp/error.jsp";
        if (userRole == Role.ADMIN) {
            List<User> users = UserDao.getAllUsers();
            request.setAttribute("allUsers", users);
            forward = "jsp/admin/all_users.jsp";
        }
        return forward;
    }
}
