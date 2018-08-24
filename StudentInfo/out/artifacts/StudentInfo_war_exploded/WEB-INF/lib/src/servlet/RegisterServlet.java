package servlet;

import controller.AccountController;
import controller.AccountControllerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //    @Resource(value = "controller.AccountControllerImpl")
    AccountController controller = new AccountControllerImpl();

    public RegisterServlet() throws SQLException, ClassNotFoundException {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String account = request.getParameter("registername");
        System.out.println("帐号" + account);
        String password = request.getParameter("registerpass");
        System.out.println("密码" + password);
        controller.test();
        boolean result = false;
        try {
            result = controller.register(account, password);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        response.getWriter().append(result + "");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
