package web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

public class LogoutCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Enumeration<String> attributes = session.getAttributeNames();
        while (attributes.hasMoreElements()){
            String attr = attributes.nextElement();
            System.out.println("attr in logout ==> " + attr);
            session.removeAttribute(attr);
        }
        String forward = CommandConstants.INDEX_JSP;
        return forward;
    }
}
