package web.command;

import db.BookDao;
import db.entity.Book;
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

        String errorMessage = null;
        String forward = "/jsp/error.jsp";

        if (title == null || yearOfPublishStr == null || author == null || edition == null || amountStr == null ||
                title.isEmpty() || yearOfPublishStr.isEmpty() || author.isEmpty() || edition.isEmpty() || amountStr.isEmpty()) {
            errorMessage = "All fields must be filled";
            session.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage" + errorMessage);
            return forward;
        }

        Book book = BookDao.findBookByTitle(title);
        System.out.println("book in createbookcom ==> " + book);

        if (book != null) {
            System.out.println("book != null" + book != null);
            if (book.getTitle().equals(title)) {
                errorMessage = "Book with such title is already exists!";
                session.setAttribute("errorMessage", errorMessage);
                return forward;
            }
        }

        Integer amount = Integer.valueOf(amountStr);
        Integer yearOfPublish = Integer.valueOf(yearOfPublishStr);
        BookDao.createBook(title, yearOfPublish, author, edition, amount);
        book = BookDao.findBookByTitle(title);
        log.trace("Book " + title + " created in a system.");
        forward = "controller?command=getAllBooks";
        if (book == null) {
            errorMessage = "Failed to create book";
            session.setAttribute("errorMessage", errorMessage); //?request.setAttribute??
            return forward;
        }
        return forward;
    }
}
