package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class JDBCManager {
    static final String URL = "jdbc:postgresql://localhost/boulderingjava?user=mihaid&password=catarat";
    private static JDBCManager INSTANCE;
    private JDBCManager() {}
    public static JDBCManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new JDBCManager();
        }
        return INSTANCE;
    }

    public boolean exists(String name) {
        try {
            Connection connection = DriverManager.getConnection(URL);
            PreparedStatement query = connection.prepareStatement(String.format("SELECT * FROM %s;", name));
            query.executeQuery();
            query.close();
            connection.close();
        }
        catch (SQLException e) {
            return false;
        }
        return true;
    }
}
