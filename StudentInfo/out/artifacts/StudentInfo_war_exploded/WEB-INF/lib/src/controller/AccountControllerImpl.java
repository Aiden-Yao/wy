package controller;

import entity.Info;
import reflect.Resource;
import service.AccountService;
import service.kow.AccountServicekow;

import java.sql.SQLException;

public class AccountControllerImpl implements AccountController{
    @Resource(value = "service.AccountService")
    AccountService service = new AccountServicekow();

    public AccountControllerImpl() throws SQLException, ClassNotFoundException {
    }

    public void test() {
        System.out.println("controller成功");
    }

    public boolean login(String account, String password) {
        return service.login(account, password);
    }

    public boolean register(String account, String password) throws NoSuchMethodException {
        return service.regist(account, password);
    }

    public <List> Info allStudentInfo(String condition1){ return (Info) service.checkAllStuInfo(condition1); }
}
