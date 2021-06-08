package web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoSuchCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
       String errorMessage = "No such command";
       request.setAttribute("errorMessage", errorMessage);
       return "/jsp/error.jsp";
    }
}
