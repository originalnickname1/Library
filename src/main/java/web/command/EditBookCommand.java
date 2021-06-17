package web.command;

import db.BookDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditBookCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        Integer yearOfPublish = Integer.valueOf(request.getParameter("yearOfPublish"));
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        Integer amount = Integer.valueOf(request.getParameter("amount"));
        String description = request.getParameter("description");

        BookDao.updateBook(id,title,yearOfPublish,author,publisher,amount,description);
        String forward = "controller?command=showBookInfo&bookId=" + id;
        return forward;
    }
}
