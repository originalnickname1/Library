package web;

import org.apache.logging.log4j.*;
import web.command.Command;
import web.command.CommandContainer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletExecutor(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletExecutor(req,resp);
    }

    private void servletExecutor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("command");
        System.out.println("controller commandName ==> " + commandName);
        Command command = CommandContainer.get(commandName);
        System.out.println("controller get command ==> " + command );
        String forward = command.execute(req,resp);
        if(forward!=null){
            RequestDispatcher dispatcher = req.getRequestDispatcher(forward);
            dispatcher.forward(req,resp);
        }
    }
}
