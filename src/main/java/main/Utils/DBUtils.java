package main.Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class DBUtils {
    /**
     *使用c3p0连接池初始化连接对象 使用见书P236
     */
    public static DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/mysql?serverTimezone=GMT%2B8");
        ds.setUser("root");
        ds.setPassword("");
        ds.setInitialPoolSize(5);
        ds.setMaxPoolSize(15);
        return ds;
    }
}
