package web.filter;

import db.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class SecurityFilter implements Filter {
    private static Map<Role, List<String>> accessMap = new HashMap<>();
    private static List<String> commons = new ArrayList<>();
    private static List<String> outOfControl = new ArrayList<>();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //if(accessAllowed(servletRequest))
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //roles
        accessMap.put(Role.ADMIN, asList(filterConfig.getInitParameter("admin")));
        accessMap.put(Role.LIBRARIAN,asList(filterConfig.getInitParameter("librarian")));
        accessMap.put(Role.USER,asList(filterConfig.getInitParameter("user")));
        //commons
        commons = asList(filterConfig.getInitParameter("common"));

        outOfControl=asList(filterConfig.getInitParameter("out-of-control"));

    }

    private boolean accessAllowed(ServletRequest request){
        HttpServletRequest httpRequest = (HttpServletRequest) request;

         String commandName = request.getParameter("command");
         if(commandName == null || commandName.isEmpty()){
             return false;
         }
         if(outOfControl.contains(commandName)){
             return true;
         }
        HttpSession session = httpRequest.getSession(false);
         return false;
    }

    private List<String> asList(String str) {
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreElements()){
            list.add(st.nextToken());
        }
        return list;
    }
}
