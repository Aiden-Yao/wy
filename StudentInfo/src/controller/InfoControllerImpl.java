package controller;

import service.InfoService;
import service.kow.InfoServicekow;

import java.lang.reflect.InvocationTargetException;

public class InfoControllerImpl implements InfoController{
    InfoService service = new InfoServicekow();

//    public List<Map<String, Object>> getInfos(Info info) {
//        return service.getInfos(info);
//    }
    public boolean modify(String condition) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException { return service.modify(condition); }
    public boolean delete(String condition){ return service.delete(condition); }
    public boolean addInfo(String condition){ return service.addInfo(condition); }
}
