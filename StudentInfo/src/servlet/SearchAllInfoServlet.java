package servlet;

import dao.base.EntityDao;
import dao.base.EntityDaoImpl;
import entity.Info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/SearchAllInfoServlet")
public class SearchAllInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //    @Resource(value = "controller.AccountControllerImpl")
    EntityDao dao = new EntityDaoImpl();

    public SearchAllInfoServlet() throws SQLException, ClassNotFoundException {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Info> studentInfos = null;
        try {
            studentInfos = dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("studentInfos", studentInfos);
        request.getRequestDispatcher("jsp/Panel.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
