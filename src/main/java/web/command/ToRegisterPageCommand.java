package web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToRegisterPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String forward = CommandConstants.ERROR_JSP;
        if (session.getAttribute("loggedUser") == null) {
            forward = "jsp/registerpage.jsp";
        }
        return forward;
    }
}
