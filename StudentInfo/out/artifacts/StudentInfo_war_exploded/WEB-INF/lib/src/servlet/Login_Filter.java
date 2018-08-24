package servlet;

import controller.AccountController;
import controller.AccountControllerImpl;
import entity.Account;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class Login_Filter implements Filter {
    AccountController controller = new AccountControllerImpl();

    public Login_Filter() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        //下次用户请求被拦截后，执行以下代码实现自动登录功能！！！
        //获得一个名为 autologin 的cookie
        Cookie[] cookies = request.getCookies();
        String autologin = null;
        String account = request.getParameter("username");
        String password = request.getParameter("password");
        boolean result = controller.login(account, password);
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("autologin".equals(cookies[i].getName())) {
                //2.找到了指定的cookie
                autologin = cookies[i].getValue();
                break;
            }
        }
        if (autologin != null) {
            //做自动登录
            String[] parts = autologin.split("-");
            String accountname = parts[0];
            String accountpass = parts[1];
            //检查用户名和密码
            if (result) {
                // 登录成功,将用户状态 user 对象存入 session域
                Account account1 = new Account();
                account1.setAccount(accountname);
                account1.setPassword(password);
                request.getSession().setAttribute("account1", account1);
            }
        }
        // 放行
        chain.doFilter(request, resp);
    }
    @Override
    public void destroy() {
    }








//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws Exception {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpSession session = request.getSession(true);
//        String accountname;
//        String sessionid;   // 此sessionid是上次用户登录时保存于用户端的识别码，用于用户后续访问的自动登录。不是本次访问的session id。
//        Cookie[] cookies;
//        CookieManager cm = new CookieManager(); // CookieManager是一个自定义的类，用于从Cookie数组中查找并返回指定名称的Cookie值。
//        boolean isAutoLogin;
//        // 如果session中没有account对象，则创建一个。
//        Account account = (Account) session.getAttribute("account");
//        if (account == null) {
//            account = new Account(); // 此时user中的username属性为""，表示用户未登录。
//        }
//        // 如果user对象的username为""，表示用户未登录。则执行自动登录过程,否则不自动登录。
//        if (account.getAccount().equals("")) {
//            // 检查用户浏览器是否发送了上次登录的用户名和sessionid，
//            // 如果是，则为用户自动登陆。
//            cookies = request.getCookies();
//            accountname = cm.getCookieValue(cookies, "autoLoginUser");
//            sessionid = cm.getCookieValue(cookies, "sessionid");
//            if(accountname.equals("wrong") || session.equals("wrong")){
//
//            }
//            isAutoLogin = cm.getAutoLoginState(accountname, sessionid); // 如果在数据库中找到了相应记录，则说明可以自动登录。
//            if (isAutoLogin) {
//                account.setAccount(accountname);
////                account.setNickname(DBUtil.getNickName(username));
//                session.setAttribute("account", account); // 将account bean添加到session中。
//            }
//        }
//        chain.doFilter(req, resp);
//    }
}
