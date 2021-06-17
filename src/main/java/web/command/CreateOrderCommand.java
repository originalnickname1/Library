package web.command;

import db.BookDao;
import db.OrderDao;
import db.Role;
import db.entity.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateOrderCommand implements Command{
    public static final Integer ZERO = 0;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forward = CommandConstants.ERROR_JSP;
        String errorMessage = null;
        HttpSession session = request.getSession();
        Role role = (Role) session.getAttribute("userRole");
        System.out.println("Role int createOrder=>>" + role);

        if(role == null || !role.equals(Role.USER)){
            errorMessage = CommandConstants.ACCESS_DENIED + "\n" + CommandConstants.ONLY_AUTHORIZED_USER;
            session.setAttribute("errorMessage",errorMessage);
            return forward;
        }
        Integer userId = (Integer) session.getAttribute("userId");
        String type = (request.getParameter("type"));
        System.out.println("type ==>" + type);
        Integer bookId = Integer.valueOf(request.getParameter("bookId"));

        Book book = BookDao.findBookById(bookId);
        if(book.getAmount()==ZERO){
            errorMessage = CommandConstants.NOT_AVAILABLE;
            session.setAttribute("errorMessage",errorMessage);
            return forward;
        }
        OrderDao.createOrder(type,userId,bookId);
        forward = CommandConstants.GREETING_PAGE;
        return forward;
    }
}
