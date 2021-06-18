package web.command;

import db.Role;
import db.UserDao;
import db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteProfileCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String errorMessage;
        User user = (User) session.getAttribute("loggedUser");
        Role role = Role.getRole(user);
        System.out.println("role in deleteProfileCommand ==>" + role);
        String forward = "error.jsp";
        if (role!=null) {
            UserDao.deleteUserById(user.getId());
            forward="controller?command=toRegisterJsp";
        } else {
            errorMessage="Access Denied!";
            session.setAttribute("errorMessage",errorMessage);
        }
        return forward;
    }
}
