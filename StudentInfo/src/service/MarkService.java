package service;

import java.lang.reflect.InvocationTargetException;

public interface MarkService {
    public boolean modifyMark(String condition) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
    public boolean deleteMark(String condition);
    public boolean addMark(String condition);
}
