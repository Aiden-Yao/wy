package dao.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil_Student_Impl implements DBUtil_Student {
    public static Connection connection = null;

//    public DBUtil_Student_Impl(){}
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection != null) {
            return connection;
        }
            System.out.println("开始加载驱动......");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动加载成功\n开始连接数据库......");
            String userName = "root";
            String password = "102698";
            String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=UTF-8";
            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("数据库连接成功......");
            return connection;
    }
}
