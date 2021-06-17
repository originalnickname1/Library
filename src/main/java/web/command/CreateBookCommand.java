package web.command;

import db.BookDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateBookCommand implements Command {
    private static final Logger log = LogManager.getLogger(CreateBookCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();


        String title = request.getParameter("title");
        String yearOfPublishStr = request.getParameter("year_of_publish");
        String author = request.getParameter("author");
        String edition = request.getParameter("edition");
        String amountStr = request.getParameter("amount");
        String description = request.getParameter("description");

        String errorMessage = null;
        String forward = "/jsp/error.jsp";

        if (title == null || yearOfPublishStr == null || author == null || edition == null || amountStr == null || description ==null ||
                title.isEmpty() || yearOfPublishStr.isEmpty() || author.isEmpty() || edition.isEmpty() || amountStr.isEmpty() || description.isEmpty()) {
            errorMessage = "All fields must be filled";
            session.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage" + errorMessage);
            return forward;
        }

        Integer amount = Integer.valueOf(amountStr);
        Integer yearOfPublish = Integer.valueOf(yearOfPublishStr);
        BookDao.createBook(title, yearOfPublish, author, edition, amount,description);
        log.trace("Book " + title + " created in a system.");
        forward = "controller?command=getAllBooks";
        return forward;
    }
}
