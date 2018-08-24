package servlet;

import controller.InfoController;
import controller.InfoControllerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    InfoController controller = new InfoControllerImpl();

    public DeleteServlet() throws SQLException, ClassNotFoundException {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuId = request.getParameter("stuId2");
        String condition="'"+stuId+"'";

        boolean result = controller.delete(condition);
        System.out.println(result);
        PrintWriter out = response.getWriter();
          if(result){
              out.print("true");
          }
          else{
              out.print("false");
          }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
