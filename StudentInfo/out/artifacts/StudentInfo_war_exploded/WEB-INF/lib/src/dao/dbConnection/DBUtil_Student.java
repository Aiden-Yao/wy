package dao.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DBUtil_Student {
    public Connection getConnection() throws SQLException, ClassNotFoundException;
}
