package web.command;

import db.BookDao;
import db.entity.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SortBooksByAuthorCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Book> books = BookDao.sortBooksByAuthor();
        String forward = CommandConstants.ERROR_JSP;
        request.setAttribute("allBooks", books);
        forward = "jsp/show_all_books.jsp";
        return forward;
    }
}
