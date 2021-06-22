package web.command;

import db.OrderDao;
import db.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PayFineCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");
        System.out.println("user in payFIne Command ==>" + user);

        OrderDao.closeOrdersByUsersId(user.getId());
        String forward = "controller?command=showProfile&userId="+user.getId();
        return forward;
    }
}
