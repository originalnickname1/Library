package web.command;

import db.OrderDao;
import db.Role;
import db.entity.Order;
import db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetAllOrdersCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String forward = CommandConstants.ERROR_JSP;
        String errorMessage;
        User user = (User) session.getAttribute("loggedUser");
        if(user==null){
            errorMessage=CommandConstants.ACCESS_DENIED;
            session.setAttribute("errorMessage",errorMessage);
            return forward;
        }
        Role userRole = Role.getRole(user);
        if(userRole!=Role.LIBRARIAN){
            errorMessage=CommandConstants.ACCESS_DENIED;
            session.setAttribute("errorMessage",errorMessage);
            return forward;
        }
        List<Order> orders = OrderDao.getAllOrders();
        request.setAttribute("allOrders", orders);
        forward = "jsp/librarian/show_all_orders.jsp";
        return forward;
    }
}
