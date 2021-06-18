package web.command;

import db.BookDao;
import db.Role;
import db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteBookCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String errorMessage;
        Integer bookId = Integer.valueOf(request.getParameter("bookId"));
        System.out.println("bookId in deleteBookCommand==>" + bookId);
        User user = (User) session.getAttribute("loggedUser");
        Role role = Role.getRole(user);
        System.out.println("role in deleteUserCommand ==>" + role);
        String forward = CommandConstants.ERROR_JSP;
        if (role.equals(Role.ADMIN)) {
            BookDao.deleteBookById(bookId);
            forward = "controller?command=getAllBooks";
        } else {
            errorMessage = "Access Denied!";
            session.setAttribute("errorMessage", errorMessage);
        }
        return forward;
    }
}
