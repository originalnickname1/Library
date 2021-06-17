package web.command;

import db.OrderDao;
import db.entity.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetAllOrdersCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        //Role userRole = (Role) session.getAttribute(CommandConstants.USER_ROLE_ATTRIBUTE);
        String forward = CommandConstants.ERROR_JSP;
        List<Order> orders = OrderDao.getAllOrders();
        request.setAttribute("allOrders", orders);
        forward = "jsp/librarian/show_all_orders.jsp";
        return forward;
    }
}
