package web.command;

import db.OrderDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("orderId"));
        String status = request.getParameter("status");
        String type = request.getParameter("type");
        Integer bookId = Integer.valueOf(request.getParameter("bookId"));

        OrderDao.updateOrder(id,status,type,bookId);
        String forward = "controller?command=showOrderInfo&orderId=" + id;
        return forward;
    }
}
