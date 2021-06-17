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
        String bId= (request.getParameter("bookId"));
        System.out.println("Book id ==>" + bId);
        Integer bookId = Integer.valueOf(bId);
        //Role role = (Role) session.getAttribute(CommandConstants.USER_ROLE_ATTRIBUTE);
        String forward = CommandConstants.ERROR_JSP;
        Book book = BookDao.findBookById(bookId);
        session.setAttribute("getBookInfo", book);
        forward = "/jsp/show_book_info.jsp";
        return forward;
    }
}
