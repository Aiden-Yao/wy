package servlet;

import controller.InfoController;
import controller.InfoControllerImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;

@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    InfoController controller = new InfoControllerImpl();

    public ModifyServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String stuId = request.getParameter("stuId");

        String stuName = request.getParameter("stuName");
        byte[] data1 = stuName.getBytes(StandardCharsets.ISO_8859_1);
        stuName = new String(data1, StandardCharsets.UTF_8);

        String stuSex = request.getParameter("stuSex");
        byte[] data2 = stuSex.getBytes(StandardCharsets.ISO_8859_1);
        stuSex = new String(data2, StandardCharsets.UTF_8);

        String stuAge = request.getParameter("stuAge");

        String stuGrade = request.getParameter("stuGrade");
        byte[] data4 = stuGrade.getBytes(StandardCharsets.ISO_8859_1);
        stuGrade = new String(data4, StandardCharsets.UTF_8);

        String stuBirthday = request.getParameter("stuBirthday");
        byte[] data5 = stuBirthday.getBytes(StandardCharsets.ISO_8859_1);
        stuBirthday = new String(data5, StandardCharsets.UTF_8);
        boolean result = false;

        String condition=" stuId='"+ stuId +"',stuName='"+stuName+"',stuSex='"+stuSex +"',stuAge=" +
                stuAge + ",stuGrade='" + stuGrade + "',stuBirthday='" + stuBirthday + "'" + " WHERE stuId ='"+stuId+"'";
        try {
            result = controller.modify(condition);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
          if(result){
              out.print("true");
          }
          else{
              out.print("false");
          }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
