package web.command;

import db.BookDao;
import db.entity.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class FindBookCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String searchBook = request.getParameter("searchBook");
        String errorMessage = null;
        String forward = CommandConstants.ERROR_JSP;
        List<Book> books = BookDao.findBookByTitle(searchBook);
        if(books.isEmpty()){
            errorMessage = "No book with such title/author";
            session.setAttribute("errorMessage",errorMessage);
            return forward;
        }
        session.setAttribute("foundedBooks",books);
        forward = "jsp/founded_books.jsp";
        return forward;
    }
}
