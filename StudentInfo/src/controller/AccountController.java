package controller;

import entity.Info;

public interface AccountController {

    public void test();

    public boolean login(String account, String password);

    public boolean register(String account, String password) throws NoSuchMethodException;

    public <List> Info allStudentInfo(String condition1);
}
