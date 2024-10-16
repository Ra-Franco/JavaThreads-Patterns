package ZZIjdbc.conn;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

    public static CachedRowSet getCachedRowSet() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String user = "root";
        String password = "root";
        CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        cachedRowSet.setUrl(url);
        cachedRowSet.setUsername(user);
        cachedRowSet.setPassword(password);
        return cachedRowSet;
    }
}
