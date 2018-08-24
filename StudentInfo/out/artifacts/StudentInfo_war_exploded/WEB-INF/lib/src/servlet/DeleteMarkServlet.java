package servlet;

import controller.MarkController;
import controller.MarkControllerImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/DeleteMarkServlet")
public class DeleteMarkServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private MarkController controller1 = new MarkControllerImpl();

    public DeleteMarkServlet() throws SQLException, ClassNotFoundException {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String stuId2 = request.getParameter("stuId2");
        String condition="'"+stuId2+"'";
        boolean result = controller1.deleteMark(condition);
        System.out.println(result);
        PrintWriter out = response.getWriter();
        if(result){
            out.print("true");
        }
        else{
            out.print("false");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
