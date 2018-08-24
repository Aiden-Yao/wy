package entity;

import dao.base.EntityDao;
import dao.base.EntityDaoImpl;

import javax.servlet.http.Cookie;
import java.sql.SQLException;
import java.util.List;

public class CookieManager {
    private String account;
    private String sessionid;
    EntityDao dao = new EntityDaoImpl();

    public CookieManager() throws SQLException, ClassNotFoundException {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }
    public String getCookieValue(Cookie[] cookies, String condition){
        for(Cookie cookie : cookies){
            cookie.getName();// get the cookie name
            cookie.getValue(); // get the cookie value
            if(cookie.getName().equals(condition)){
                return cookie.getName();
            }
            if(cookie.getValue().equals(condition)){
                return cookie.getValue();
            }
        }
        return "wrong";
    }
    public boolean getAutoLoginState(String accountname, String sessionid) throws Exception {
        List<CookieManager> cookieManagers = dao.findCookie();
        for(int i = 0;i < cookieManagers.size(); i++){
            if(accountname.equals(cookieManagers.get(i).getAccount())&&sessionid.equals(cookieManagers.get(i).sessionid)){
                return true;
            }
        }
        return false;
    }
}
