package web.command;

import db.BookDao;
import db.entity.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowBookInfoCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Integer bookId = Integer.valueOf((request.getParameter("bookId")));
        String forward = CommandConstants.ERROR_JSP;
        Book book = BookDao.findBookById(bookId);
        session.setAttribute("getBookInfo", book);
        forward = "/jsp/show_book_info.jsp";

        return forward;
    }
}
