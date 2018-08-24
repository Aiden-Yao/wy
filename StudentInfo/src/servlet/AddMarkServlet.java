package servlet;

import controller.MarkController;
import controller.MarkControllerImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

@WebServlet("/AddMarkServlet")
public class AddMarkServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private MarkController controller1 = new MarkControllerImpl();

    public AddMarkServlet() throws SQLException, ClassNotFoundException {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String stuId = request.getParameter("stuId");
        String dataStructure = request.getParameter("dataStructure");
        String math = request.getParameter("math");
        String English = request.getParameter("English");
        String computer = request.getParameter("computer");

        String stuName = request.getParameter("stuName");
        byte[] data1 = stuName.getBytes(StandardCharsets.ISO_8859_1);
        stuName = new String(data1, StandardCharsets.UTF_8);

        String condition="(stuId,stuName,dataStructure,math,English,computer)values " +
                "('"+stuId+"','"+stuName+"',"+dataStructure+","+math+","+English+","+computer+")";
        System.out.println(condition);
        boolean result = controller1.addMark(condition);
        System.out.println(result);
        PrintWriter out = response.getWriter();
        if(result){
            out.print("true");
        } else{
            out.print("false");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
