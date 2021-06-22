package web.command;

import db.Blocked;
import db.OrderDao;
import db.Role;
import db.UserDao;
import db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowProfileCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");
        Role role = Role.getRole(user);
        String forward = CommandConstants.ERROR_JSP;
        if (role != null) {
            user = UserDao.findUserById(user.getId());
            Integer fine = OrderDao.getUserFine(user.getId());
            System.out.println("fine in showprofile==> " + fine);
            session.setAttribute("getUserInfoFine",fine);
            Blocked getUserInfoBlocked = Blocked.getBlocked(user);
            session.setAttribute("loggedUser",user);
            System.out.println("getUserInfoBlocked" + user.getBlocked());
            System.out.println("getUserInfoRole" + role);
            session.setAttribute("getUserInfoRole", role);
            session.setAttribute("getUserInfoBlocked", getUserInfoBlocked);
            forward = "/jsp/user/show_profile.jsp";
        }

        return forward;
    }
}
