package service.kow;

import dao.base.EntityDao;
import dao.base.EntityDaoImpl;
import entity.Info;
import reflect.Resource;
import service.InfoService;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfoServicekow implements InfoService {
    @Resource(value = "dao.base.EntityDaoImpl")
    EntityDao dao;

    {
        try {
            dao = new EntityDaoImpl();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Map<String ,Object>> getInfos(Info info){
        List<Info> infos = null;
        String condition = "";
        infos = dao.getEntitysByCondition(condition, Info.class);

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//出生年月格式
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();//键值对形式
        if (infos == null) {
            return null;
        }
        for (Info info1: infos) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("stuId",info1.getStuId());
            map.put("stuName",info1.getStuName());
            map.put("stuSex",info1.getStuSex());
            map.put("stuAge",info1.getStuAge());
            map.put("stuGrade",info1.getStuGrade());
            map.put("stuBirthday",info1.getStuBirthday());
            result.add(map);
        }
        return result;
    }
    public boolean modify(String condition) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        int result = dao.updateEntityByCondition(condition, Info.class);
        if(result == 0){
            return false;
        }
        return true;
    }
    public boolean delete(String condition){
        int result = dao.deleteEntitys(condition, Info.class);
        if(result == 0){
            return false;
        }
        return true;
    }
    public boolean addInfo(String condition){
        int result = dao.addEntity(condition, Info.class);
        if(result == 0){
            return false;
        }
        return true;
    }
}
