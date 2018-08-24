package controller;

import service.MarkService;
import service.kow.MarkServicekow;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class MarkControllerImpl implements MarkController{
    private MarkService service = new MarkServicekow();

    public MarkControllerImpl() throws SQLException, ClassNotFoundException {
    }

    public boolean modifyMark(String condition) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException { return service.modifyMark(condition); }
    public boolean deleteMark(String condition){ return service.deleteMark(condition); }
    public boolean addMark(String condition){ return service.addMark(condition); }
}
