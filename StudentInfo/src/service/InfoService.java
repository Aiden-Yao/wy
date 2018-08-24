package service;

import entity.Info;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface InfoService {
    public List<Map<String ,Object>> getInfos(Info info);
    public boolean modify(String condition) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    public boolean delete(String condition);
    public boolean addInfo(String condition);
}
