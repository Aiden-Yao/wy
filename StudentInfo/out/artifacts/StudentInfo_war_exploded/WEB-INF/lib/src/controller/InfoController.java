package controller;

import java.lang.reflect.InvocationTargetException;

public interface InfoController {
//    public List<Map<String, Object>> getInfos(Info info);
    public boolean modify(String condition) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
    public boolean delete(String condition);
    public boolean addInfo(String condition);
}
