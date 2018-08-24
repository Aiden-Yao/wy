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

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    InfoController controller = new InfoControllerImpl();

    public AddServlet() throws SQLException, ClassNotFoundException {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuId = request.getParameter("stuId");

        String stuName = request.getParameter("stuName");
        byte[] data1 = stuName.getBytes("ISO-8859-1");
        stuName = new String(data1, "utf-8");

        String stuSex = request.getParameter("stuSex");
        byte[] data2 = stuSex.getBytes("ISO-8859-1");
        stuSex = new String(data2, "utf-8");

        String stuAge = request.getParameter("stuAge");

        String stuGrade = request.getParameter("stuGrade");
        byte[] data4 = stuGrade.getBytes("ISO-8859-1");
        stuGrade = new String(data4, "utf-8");

        String stuBirthday = request.getParameter("stuBirthday");
        byte[] data5 = stuBirthday.getBytes("ISO-8859-1");
        stuBirthday = new String(data5, "utf-8");

        String condition = "(stuId,stuName,stuSex,StuAge,stuGrade,stuBirthday)values " +
                "('" + stuId + "','" + stuName + "','" + stuSex + "'," + stuAge + ",'" + stuGrade + "','" + stuBirthday + "')";
        boolean result = false;
        result = controller.addInfo(condition);
        System.out.println(result);
        PrintWriter out = response.getWriter();
        if (result) {
            out.print("true");
        } else {
            out.print("false");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
