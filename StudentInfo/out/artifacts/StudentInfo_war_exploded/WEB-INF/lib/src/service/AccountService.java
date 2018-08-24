package service;

import entity.Info;

import java.util.List;

public interface AccountService {
    public boolean login(String account,String password);

    public boolean regist(String account,String password) throws NoSuchMethodException;

    public List<Info> checkAllStuInfo(String condition);
}
