package servlet;

import controller.MarkController;
import controller.MarkControllerImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

@WebServlet("/ModifyMarkServlet")
public class ModifyMarkServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private MarkController controller1 = new MarkControllerImpl();

    public ModifyMarkServlet() throws SQLException, ClassNotFoundException {
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

        boolean result = false;

        String condition = " stuId='" + stuId + "',stuName='" + stuName + "',dataStructure=" + dataStructure + ",math=" +
                math + ",English=" + English + ",computer=" + computer + " WHERE stuId ='" + stuId + "'";
        try {
            result = controller1.modifyMark(condition);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        if (result) {
            out.print("true");
        } else {
            out.print("false");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
