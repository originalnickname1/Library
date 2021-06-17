package web.command;

import db.OrderDao;
import db.Role;
import db.entity.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowOrderInfo implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Integer orderId = Integer.valueOf(request.getParameter("orderId"));
        System.out.println("orderId in editordercommand =  " + orderId);
        Role role = (Role) session.getAttribute(CommandConstants.USER_ROLE_ATTRIBUTE);
        String forward = CommandConstants.ERROR_JSP;
        if (role == Role.LIBRARIAN) {
            Order order = OrderDao.findOrderById(orderId);
            session.setAttribute("getOrderInfo", order);
            forward = "/jsp/librarian/show_order_info.jsp";
        }
        return forward;
    }
}
