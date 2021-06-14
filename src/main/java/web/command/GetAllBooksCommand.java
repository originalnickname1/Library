package web.command;

import db.BookDao;
import db.Role;
import db.entity.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetAllBooksCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Role userRole = (Role) session.getAttribute(CommandConstants.USER_ROLE_ATTRIBUTE);
        String forward = CommandConstants.ERROR_JSP;
        List<Book> books = BookDao.getAllBooks();
        request.setAttribute("allBooks", books);
        forward = "jsp/show_all_books.jsp";
        return forward;
    }
}

