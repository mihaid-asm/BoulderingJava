package interfaces;

import java.sql.*;
import java.util.Optional;
import java.util.Vector;
import utility.*;

public interface Persistence {
    static final String URL = "jdbc:postgresql://localhost/boulderingjava?user=mihaid&password=catarat";
    String tableName();
    Vector<utility.Pair<String, String>> tableColumns();
    Vector<String> tableValues();
    int pk();

    default void create() {
        try {
            Connection connection = DriverManager.getConnection(URL);
            StringBuilder columns = new StringBuilder();
            for (utility.Pair<String, String> column : tableColumns()) {
                columns.append(",\n").append(column.getKey()).append(" ").append(column.getValue());
            }

            String sql = String.format(
                    """
                            CREATE TABLE IF NOT EXISTS %s (%s_ID INT PRIMARY KEY%s)
                    """,
                    tableName(),
                    tableName(),
                    columns
            );

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Logs.log(e.getMessage());
        }
    }

    default void insert() {
        try {
            Connection connection = DriverManager.getConnection(URL);
            String query = String.format(
                    """
                            INSERT INTO %s VALUES(%s%s)
                    """,
                    tableName(),
                    pk(),
                    new String(new char[tableValues().size()]).replace("\0", ", ?")
            );

            PreparedStatement statement = connection.prepareStatement(query);

            for (int i = 0; i < tableValues().size(); i++) {
                statement.setString(i + 1, tableValues().get(i));
            }

            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Logs.log(e.getMessage());
        }
    }

    default void update() {
        try {
            Connection connection = DriverManager.getConnection(URL);

            StringBuilder names = new StringBuilder();
            for (utility.Pair<String, String> column : tableColumns()) {
                names.append(column.getKey()).append(" = ?").append(",\n");
            }
            names.deleteCharAt(names.length() - 2);

            String query = String.format(
                    """
                            UPDATE %s SET %s WHERE %s_ID=%s
                    """,
                    tableName(),
                    names,
                    tableName(),
                    pk()
            );

            PreparedStatement statement = connection.prepareStatement(query);

            for (int i = 0; i < tableValues().size(); i++) {
                statement.setString(i + 1, tableValues().get(i));
            }

            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Logs.log(e.getMessage());
        }
    }

    default void drop() {
        try {
            Connection connection = DriverManager.getConnection(URL);

            String sql = String.format(
                    """
                            DROP TABLE %s
                    """,
                    tableName()
            );

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Logs.log(e.getMessage());
        }
    }

    default void delete() {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String sql = String.format("DELETE FROM %s WHERE %s_ID=%s",
                    tableName(),
                    tableName(),
                    pk());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            Logs.log(e.getMessage());
        }
    }

    default Optional<Vector<String>> load(int pk) {
        try {
            Connection connection = DriverManager.getConnection(URL);

            String sql = String.format(
                    """
                        SELECT * FROM %s WHERE %s_ID=%s
                    """,
                    tableName(),
                    tableName(),
                    pk
            );

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            Vector<String> values = new Vector<>();

            if (results.next()) {
                for (Pair<String, String> column : tableColumns()) {
                    values.add(results.getString(column.getKey()));
                    values.add(results.getString(column.getKey()));
                }
            }

            statement.close();
            connection.close();
            return Optional.of(values);
        } catch (SQLException e) {
            e.printStackTrace();
            Logs.log(e.getMessage());
            return Optional.empty();
        }
    }
}
