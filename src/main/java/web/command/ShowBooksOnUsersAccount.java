package web.command;

import db.OrderDao;
import db.entity.Order;
import db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ShowBooksOnUsersAccount implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");
        Integer userId = user.getId();
        List<Order> orders = OrderDao.findOrderByUserId(userId);
        List<Order> confirmedOrders = new ArrayList<>();
        for (Order order: orders) {
            if(order.getStatus().equals("CONFIRMED")){
                confirmedOrders.add(order);
            }
        }
        session.setAttribute("confirmedOrders",confirmedOrders);
        return "jsp/user/show_books_on_acc.jsp";
    }
}
