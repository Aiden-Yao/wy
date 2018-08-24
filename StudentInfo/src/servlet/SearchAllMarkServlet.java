package servlet;

import dao.base.EntityDao;
import dao.base.EntityDaoImpl;
import entity.Mark;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/SearchAllMarkServlet")
public class SearchAllMarkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EntityDao dao = new EntityDaoImpl();

    public SearchAllMarkServlet() throws SQLException, ClassNotFoundException {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Mark> studentMarks = null;
        try {
            studentMarks = dao.findMark();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("studentMarks", studentMarks);
        request.getRequestDispatcher("jsp/markPanel.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
