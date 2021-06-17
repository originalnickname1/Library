package web.command;

import db.OrderDao;
import db.Role;
import db.entity.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowOrdersByUserIdCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String forward = CommandConstants.ERROR_JSP;
        String errorMessage = null;
        String message = "List Of Orders : ";

        Integer userId = (Integer) session.getAttribute("userId");
        Role role = (Role) session.getAttribute(CommandConstants.USER_ROLE_ATTRIBUTE);
        if (role == null) {
            errorMessage = CommandConstants.ACCESS_DENIED;
            session.setAttribute("errorMessage", errorMessage);
            return forward;
        }
        List<Order> orders = OrderDao.findOrderByUserId(userId);
        if(orders.isEmpty()){
            message = "Your Order List Is empty";
        }
        session.setAttribute("message",message);
        session.setAttribute("userOrders",orders);
        forward = "jsp/user/user_show_requested_info.jsp";
        return forward;
    }
}
