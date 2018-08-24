package servlet;

import controller.AccountController;
import controller.AccountControllerImpl;
import dao.base.EntityDao;
import dao.base.EntityDaoImpl;
import entity.Account;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
//    @Resource(value = "controller.AccountControllerImpl")
    AccountController controller = new AccountControllerImpl();
    EntityDao dao = new EntityDaoImpl();
    private Account account1 = new Account();

    public LoginServlet() throws SQLException, ClassNotFoundException {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
//        String autologin = request.getParameter("chk1");
        String account = request.getParameter("username");
//        System.out.println("帐号" + account);
        String password = request.getParameter("password");
//        System.out.println("密码" + password);
//        controller.test();
        boolean result = controller.login(account, password);
//        if(result){
//            //将用户状态 account1 对象存入 session域
//            account1.setAccount(account);
//            account1.setPassword(password);
//            request.getSession().setAttribute("account1", account1);
//            //发送自动登录的cookie
//            String autoLogin = request.getParameter("chk1");
//            if(autoLogin.equals("true")){
//                //注意 cookie 中的密码要加密
//                Cookie cookie = new Cookie("autologin", account + "-"
//                        + password);
//                cookie.setMaxAge(60 * 60 * 24 * 14);//两周
//                cookie.setPath(request.getContextPath());
//                response.addCookie(cookie);
//            }
//        }







//        HttpSession session = request.getSession();
//
//        Cookie ckAccountname, ckSessionid;
//        String sessionid;
//        if (autologin.equals("true")) {
//            ckAccountname = new Cookie("autoLoginUser", account1.getAccount());
//            ckAccountname.setMaxAge(60 * 60 * 24 * 14);   //设置Cookie有效期为14天
//            response.addCookie(ckAccountname);
//            sessionid = session.getId(); // 取得当前的session id
//            ckSessionid = new Cookie("sessionid", sessionid);
//            ckSessionid.setMaxAge(60 * 60 * 24 * 14);
//            response.addCookie(ckSessionid);
//            // 在数据库中插入相应记录
//            int result1 = dao.addAccountSession(account, sessionid);
//            System.out.println(result1);
//        }





//        if(result){
//            response.sendRedirect("jsp/Panel.jsp");
//        }
//        request.setAttribute("infos", result);
//        request.getRequestDispatcher("jsp/Panel.jsp").forward(request, response);

//        response.getWriter().append(result + "");
        PrintWriter out = response.getWriter();
        if(result){
            out.print("true");
        }else{
            out.print("false");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doGet(request, response);
    }
}
