package web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToRegisterPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forward = "jsp/registerpage.jsp";

        return forward;
    }
}
