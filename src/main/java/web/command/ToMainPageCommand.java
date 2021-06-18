package web.command;

import db.Role;
import db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToMainPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");
        System.out.println("user main ==>" + user);
        Role role = Role.getRole(user);
        System.out.println("role to main ==>" + role);
        String forward = "jsp/error_page.jsp";
        if(user!=null && role!=null){
            forward = CommandConstants.GREETING_PAGE;
        }
        return forward;
    }
}
