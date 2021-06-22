package web.command;

import db.Blocked;
import db.Role;
import db.UserDao;
import db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowUserInfo implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        System.out.println("editUserId id ind editusercommand =  " + userId);
        User user = (User) session.getAttribute("loggedUser");
        String forward = CommandConstants.ERROR_JSP;
        if (user == null) {
            String errorMessage = CommandConstants.ACCESS_DENIED;
            session.setAttribute("errorMessage", errorMessage);
            return forward;
        }
        Role role = Role.getRole(user);
        if (role != Role.ADMIN) {
            String errorMessage = CommandConstants.ACCESS_DENIED;
            session.setAttribute("errorMessage", errorMessage);
            return forward;
        }
        user = UserDao.findUserById(userId);
        session.setAttribute("getUserInfo", user);
        Role getUserInfoRole = Role.getRole(user);
        Blocked getUserInfoBlocked = Blocked.getBlocked(user);
        session.setAttribute("getUserInfoRole", getUserInfoRole);
        session.setAttribute("getUserInfoBlocked", getUserInfoBlocked);
        forward = "/jsp/admin/show_user_info.jsp";


        return forward;

    }
}