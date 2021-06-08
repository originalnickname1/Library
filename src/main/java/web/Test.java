package web;

import db.UserDao;
import db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/test")
public class Test extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String login = req.getParameter("login");
        System.out.println("servlet /login attribute login ==> " + login);
        String password = req.getParameter("password");
        System.out.println("servlet /login attribute password ==> " + password);
        User user = UserDao.findUserByLogin(login);
        if(user == null || !user.getPassword().equals(password)){
            resp.sendRedirect("jsp/error.jsp");
            return;
        }
        session.setAttribute("loggedUser", login);
        resp.sendRedirect("jsp/greeting_page.jsp");
    }
}
