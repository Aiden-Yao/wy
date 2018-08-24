package service.kow;

import dao.base.EntityDao;
import dao.base.EntityDaoImpl;
import entity.Account;
import entity.Info;
import reflect.Resource;
import service.AccountService;

import java.sql.SQLException;
import java.util.List;

public class AccountServicekow implements AccountService {
    @Resource(value = "dao.base.EntityDaoImpl")
    EntityDao dao = new EntityDaoImpl();

    public AccountServicekow() throws SQLException, ClassNotFoundException {
    }

    @Override
    public boolean login(String account, String password) {
        String condition = "";
        if (account != null && !account.isEmpty()) {
            condition += " and account='" + account + "'";
        }
        if (password != null && !password.isEmpty()) {
            condition += " and password='" + password + "'";
        }
        if (condition.equals("")) {
            return false;
        }

        Account account2 = dao.getEntityByCondition(condition, Account.class);
        if (account2 == null)
            return false;

        return true;
    }

    @Override
    public boolean regist(String username, String password) throws NoSuchMethodException {
        String condition = "";
        if (username != null && !username.isEmpty()) {
            condition += username + "','";
        }
        if (password != null && !password.isEmpty()) {
            condition += password + "')";
        }
        if (condition.equals("")) {
            return false;
        }

        int result = dao.saveEntity(condition, Account.class);
        if (result > 0)
            return true;
        return false;
    }

    @Override
    public List<Info> checkAllStuInfo(String condition){
        List<Info> studentInfo = (List<Info>) dao.getEntityByCondition(condition, Info.class);
        return studentInfo;
    }
}
