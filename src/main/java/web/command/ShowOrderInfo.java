package web.command;

import db.OrderDao;
import db.Role;
import db.entity.Order;
import db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowOrderInfo implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");
        Integer orderId = Integer.valueOf(request.getParameter("orderId"));
        System.out.println("orderId in show order info =  " + orderId);
        Role role = Role.getRole(user);
        String forward = CommandConstants.ERROR_JSP;
        if (role!=null) {
            Order order = OrderDao.findOrderById(orderId);
            session.setAttribute("getOrderInfo", order);
            forward = "/jsp/librarian/show_order_info.jsp";
        }
        return forward;
    }
}
