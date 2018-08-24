package dao.base;

import entity.CookieManager;
import entity.Info;
import entity.Mark;
import entity.base.Entity;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface EntityDao {
    public <T extends Entity> List<T> getEntitysByCondition(String condition, Class<T> t);
    public <T extends Entity> T getEntityByCondition(String condition, Class<T> clazz) ;
    public <T extends Entity> int saveEntity(String condition, Class<T> clazz) throws NoSuchMethodException;
    public <T extends Entity> int updateEntityByCondition(String condition, Class<T> clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
    public <T extends Entity> int deleteEntitys(String condition, Class<T> clazz);
    public <T extends Entity> int addEntity(String condition, Class<T> clazz);
    public void closeResource();
    public List<Info> findAll() throws Exception;
    public List<Mark> findMark() throws Exception;
    public int addAccountSession(String account, String sessionid);
    public List<CookieManager> findCookie() throws Exception;
}
