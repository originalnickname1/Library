package web.command;

import db.Role;
import db.UserDao;
import db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        HttpSession session = request.getSession();
        String errorMessage;
        User user = (User) session.getAttribute("loggedUser");
        System.out.println("userId in deleteUserCommand==>" + userId);
        Role role = Role.getRole(user);
        System.out.println("role in deleteUserCommand ==>" + role);
        String forward = "error.jsp";
        if (role.equals(Role.ADMIN)) {
            UserDao.deleteUserById(userId);
            forward="controller?command=admin%3FgetAllUsers";
        } else {
            errorMessage="Access Denied!";
            session.setAttribute("errorMessage",errorMessage);
        }
        return forward;
    }
}
