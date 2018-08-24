package dao.base;

import dao.dbConnection.DBUtil_Student;
import dao.dbConnection.DBUtil_Student_Impl;
import entity.CookieManager;
import entity.Info;
import entity.Mark;
import entity.base.Entity;
import reflect.Column;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntityDaoImpl implements EntityDao {

//    private static Connection connection = DBUtil_Student_Impl.getConnection();
    private static EntityDaoImpl dao = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
//    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    DBUtil_Student dbUtil_student = new DBUtil_Student_Impl();
    Connection connection = dbUtil_student.getConnection();
    private Object object;

    public EntityDaoImpl() throws SQLException, ClassNotFoundException {
    }

    public <T extends Entity> List<T> getEntitysByCondition(String condition, Class<T> t) {
        List<T> resultList = new ArrayList<T>();
        Field[] fields = t.getDeclaredFields();

        try {
            Constructor<?> constructor = t.getConstructor();//通过Constructor实例化对象
            Object entity = constructor.newInstance();
            Method method = t.getMethod("getTableName");
            String tableName = (String)method.invoke(entity);
            String sql = "select * from " + tableName + " where 1=1 ";
            if(condition != null && !condition.isEmpty()){
                sql += condition;
            }
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                T temp = t.newInstance();
                for (Field field : fields) {
                    Column annotation = field.getAnnotation(Column.class);
                    if (annotation != null) {
                        String sqlName = annotation.value();
                        String type = annotation.type();
                        String methodName = "set" + field.getName().toUpperCase().charAt(0)
                                + field.getName().substring(1);
                        if (type.equals("Integer")) {
                            temp.getClass().getMethod(methodName, Integer.class).invoke(temp, rs.getInt(sqlName));
                        }
                        if (type.equals("String")) {
                            temp.getClass().getMethod(methodName, String.class).invoke(temp, rs.getString(sqlName));
                        }
                        if (type.equals("Double")) {
                            temp.getClass().getMethod(methodName, Double.class).invoke(temp, rs.getDouble(sqlName));
                        }
                        if (type.equals("Date")) {
                            temp.getClass().getMethod(methodName, Date.class).invoke(temp, new Date(rs.getDate(sqlName).getTime()));
                        }
                    }
                }
                resultList.add(temp);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | SQLException | InvocationTargetException e) {
            e.printStackTrace();
        }
        closeResource();
        return resultList;
    }

    public <T extends Entity> T getEntityByCondition(String condition, Class<T> clazz) {
        List<T> list = getEntitysByCondition(condition, clazz);
        if(condition.equals("and true")){//返回整个表单的数据
            return (T) list;
        }
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public <T extends Entity> int saveEntity(String condition, Class<T> clazz) throws NoSuchMethodException {
        @SuppressWarnings("unchecked")
        T entity = (T) object;
//        Class<?> t = clazz; // 获得object的Class对象
        Field[] fields = clazz.getDeclaredFields();
        Column annotation = null;
        int result = 0;//密码或帐号为空的情况已经在Service里面判断了，并返回false，所以此处可以直接用一个int来返回结果

        try {
            String sql = "insert into " + clazz.getMethod("getTableName").invoke(clazz.newInstance()) + "(";
            for (int i = 0; i < fields.length; i++) // 拼接sql语句
            {
                annotation = fields[i].getAnnotation(Column.class);
                if (i == 0) {
                    sql += annotation.value() + ",";
                    continue;
                }
                if(i == 1){
                    sql += annotation.value() + ")" + "values('";
                }
//                sql += ", " + annotation.value();
            }
//            sql += ") values(?";
//            for (int i = 2; i < fields.length; i++) {
//                sql += ",?";
//            }
//            sql += ")";
            sql += condition;
            System.out.println(sql);
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
//            for (int i = 1; i < fields.length; i++) {
//                String methodName = "get" + fields[i].getName().toUpperCase().charAt(0)
//                        + fields[i].getName().substring(1);
//                Method method = clazz.getMethod(methodName);
//                annotation = fields[i].getAnnotation(Column.class);
//                String type = annotation.type();
//                Object object1 = method.invoke(entity);
//                if (type.equals("Integer")) {
//                    if (object1 != null)
//                        ps.setInt(i, (Integer) object1);
//                    else
//                        ps.setInt(i, 0);
//                }
//                if (type.equals("String")) {
//                    if (object1 != null)
//                        ps.setString(i, (String) object1);
//                    else
//                        ps.setString(i, null);
//                }
//                if (type.equals("Double")) {
//                    if (object1 != null)
//                        ps.setDouble(i, (Double) object1);
//                    else
//                        ps.setDouble(i, 0);
//                }
//                if (type.equals("Date")) {
//                    if (object1 != null)
//                        ps.setDate(i, new java.sql.Date(((Date) object1).getTime()));
//                    else
//                        ps.setDate(i, null);
//                }
//            }

//            result = ps.executeUpdate();
            result++;
            System.out.println(result);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }

        closeResource();
        return result;
    }

    public <T extends Entity> int updateEntityByCondition(String condition, Class<T> clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        int result = 0;
//        T entity = (T) object;
//        Field[] fields = clazz.getDeclaredFields();
//        Column column = null;
        if (condition == null || condition.isEmpty()) {
            return 0;//返回0代表sql语句错误
        }
        String sql = "update " + clazz.getMethod("getTableName").invoke(clazz.newInstance()) + " set " + condition;
        try {
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            result++;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        closeResource();
        return result;//返回1代表更新成功
//        String methodName = "get";
//        String columnName = "";
//        String type = "";

//        try {
//            methodName += fields[0].getName().toUpperCase().charAt(0) + fields[0].getName().substring(1);
//            Object object1 = clazz.getMethod(methodName).invoke(entity);
//            if (object1 != null) {
//                sql += (Integer) object1;
//            }
//            for (int i = 1; i < fields.length; i++) {
//                object1 = null;
//                methodName = "get";
//                column = fields[i].getAnnotation(Column.class);
//                columnName = column.value();
//                type = column.type();
//                methodName += fields[i].getName().toUpperCase().charAt(0) + fields[i].getName().substring(1);
//                object1 = clazz.getMethod(methodName).invoke(entity);
//                if (type.equals("Integer")) {
//                    if (object1 != null)
//                        sql += ", " + columnName + "= " + (Integer) object1;
//                }
//                if (type.equals("String")) {
//                    if (object1 != null)
//                        sql += ", " + columnName + "= '" + (String) object1 + "'";
//                }
//                if (type.equals("Double")) {
//                    if (object1 != null)
//                        sql += ", " + columnName + "= " + (Double) object1;
//                }
//                if (type.equals("Date")) {
//                    if (object1 != null)
//                        sql += ", " + columnName + "= '" + new java.sql.Date(((Date) object1).getTime()) + "'";
//                }
//            }

    }

    public <T extends Entity> int deleteEntitys(String condition, Class<T> clazz) {
        if(condition == null ||condition.isEmpty()){
            return 0;
        }
//        System.out.println(condition + "sdadassdsad");
        int result = 0;
        String sql = null;
        try {
            sql = "delete from " + clazz.getMethod("getTableName").invoke(clazz.newInstance()) + " where stuId =" + condition;
            System.out.println(sql);
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            result++;
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException | SQLException e) {
            e.printStackTrace();
        }
        closeResource();
        return result;
//        Integer[] newIds = (Integer[]) ids;
//
//        for (Integer id : newIds) {
//            try {
//                String sql = "delete from " + clazz.getMethod("getTableName").invoke(clazz.newInstance()) + " where id="
//                        + id;
//                ps = connection.prepareStatement(sql);
//                result += ps.executeUpdate();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public void closeResource() {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("PreparedStatement关闭失败");
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("ResultSet关闭失败");
            }
        }
    }

        public List<Info> findAll() throws Exception {
        String sql = "SELECT * FROM studentinfo";
        List<Info> studentInfos = new ArrayList<>();
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        ResultSetMetaData data = rs.getMetaData();
        while (rs.next()) {
            Info info = new Info();
            for (int i = 1; i <= data.getColumnCount(); i++) { //getColumnCount多少数据 ‘行’
                String rowValue = rs.getString(i);
//                System.out.println(rowValue);
                switch (i) {
                    case 1: {
                        info.setStuId(rowValue);
                        break;
                    }
                    case 2: {
                        info.setStuName(rowValue);
                        break;
                    }
                    case 3: {
                        info.setStuSex(rowValue);
                        break;
                    }
                    case 4: {
                        info.setStuAge(Integer.parseInt(rowValue));
                        break;
                    }
                    case 5: {
                        info.setStuGrade(rowValue);
                        break;
                    }
                    case 6: {
                        info.setStuBirthday(rowValue);
                        break;
                    }
                }
            }
            studentInfos.add(info);
        }
        return studentInfos;
    }
    public List<Mark> findMark() throws Exception {
        String sql1 = "SELECT * FROM studentmark";
        List<Mark> studentMarks = new ArrayList<>();
        ps = connection.prepareStatement(sql1);
        rs = ps.executeQuery();
        ResultSetMetaData data = rs.getMetaData();
        while (rs.next()) {
            Mark mark = new Mark();
            for (int i = 1; i <= data.getColumnCount(); i++) { //getColumnCount多少数据 ‘行’
                String rowValue = rs.getString(i);
                switch (i) {
                    case 1: {
                        mark.setStuId(rowValue);
                        break;
                    }
                    case 2: {
                        mark.setStuName(rowValue);
                        break;
                    }
                    case 3: {
                        mark.setDataStructure(Integer.parseInt(rowValue));
                        break;
                    }
                    case 4: {
                        mark.setMath(Integer.parseInt(rowValue));
                        break;
                    }
                    case 5: {
                        mark.setEnglish(Integer.parseInt(rowValue));
                        break;
                    }
                    case 6: {
                        mark.setComputer(Integer.parseInt(rowValue));
                        break;
                    }
                }
            }
            studentMarks.add(mark);
        }
        return studentMarks;
    }
    public List<CookieManager> findCookie() throws Exception {
        String sql2 = "SELECT * FROM session";
        List<CookieManager> cookieManagers = new ArrayList<>();
        ps = connection.prepareStatement(sql2);
        rs = ps.executeQuery();
        ResultSetMetaData data = rs.getMetaData();
        while (rs.next()) {
            CookieManager cookieManager = new CookieManager();
            for (int i = 1; i <= data.getColumnCount(); i++) { //getColumnCount多少数据 ‘行’
                String rowValue = rs.getString(i);
                switch (i) {
                    case 1: {
                        cookieManager.setAccount(rowValue);
                        break;
                    }
                    case 2: {
                        cookieManager.setSessionid(rowValue);
                        break;
                    }
                }
            }
            cookieManagers.add(cookieManager);
        }
        return cookieManagers;
    }
    public <T extends Entity> int addEntity(String condition, Class<T> clazz) {
        if(condition == null ||condition.isEmpty()){
            return 0;
        }
        int result = 0;
        String sql = null;
        try {
            sql = "insert into " + clazz.getMethod("getTableName").invoke(clazz.newInstance()) + condition;
            System.out.println(sql);
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            result++;
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException | SQLException e) {
            e.printStackTrace();
        }
        closeResource();
        return result;
    }
    public int addAccountSession(String account, String sessionid){
        if(account == null || account.isEmpty()){
            return 0;
        }
        int result = 0;
        String sql = "insert into session(account,sessionid) values('" + account + "','" + sessionid+ "')";
        System.out.println(sql);
        try {
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            result++;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResource();
        return result;
    }
    public static EntityDao getEntityDao() throws SQLException, ClassNotFoundException {
        if(dao == null) {
            dao = new EntityDaoImpl();
        }
        return dao;
    }
}
