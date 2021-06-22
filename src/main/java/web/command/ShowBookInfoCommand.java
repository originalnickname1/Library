package web.command;

import db.BookDao;
import db.UserDao;
import db.entity.Book;
import db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowBookInfoCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Integer bookId = Integer.valueOf((request.getParameter("bookId")));
        User user= (User) session.getAttribute("loggedUser");
        Integer userId = user.getId();
        user = UserDao.findUserById(userId);
        session.setAttribute("loggedUser", user);
        String forward = CommandConstants.ERROR_JSP;
        Book book = BookDao.findBookById(bookId);
        session.setAttribute("getBookInfo", book);
        forward = "/jsp/show_book_info.jsp";
        return forward;
    }
}
