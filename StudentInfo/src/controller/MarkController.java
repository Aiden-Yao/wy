package controller;

import java.lang.reflect.InvocationTargetException;

public interface MarkController {
    public boolean modifyMark(String condition) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
    public boolean deleteMark(String condition);
    public boolean addMark(String condition);
}
