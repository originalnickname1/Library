package web.command;

import db.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditProfileCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Integer blocked = Integer.valueOf(request.getParameter("blocked"));
        Integer roleId = Integer.valueOf(request.getParameter("roleId"));

        UserDao.updateUser(id,login,password,firstName,lastName,blocked,roleId);
        String forward = "controller?command=showProfile&userId=" + id;
        return forward;
    }
}
