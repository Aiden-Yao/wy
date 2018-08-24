package service.kow;

import dao.base.EntityDao;
import dao.base.EntityDaoImpl;
import entity.Mark;
import service.MarkService;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class MarkServicekow implements MarkService {
    EntityDao dao = new EntityDaoImpl();

    public MarkServicekow() throws SQLException, ClassNotFoundException {
    }

    public boolean modifyMark(String condition) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        int result = dao.updateEntityByCondition(condition, Mark.class);
        if(result == 0){
            return false;
        }
        return true;
    }
    public boolean deleteMark(String condition){
        int result = dao.deleteEntitys(condition, Mark.class);
        if(result == 0){
            return false;
        }
        return true;
    }
    public boolean addMark(String condition){
        int result = dao.addEntity(condition, Mark.class);
        if(result == 0){
            return false;
        }
        return true;
    }
}
