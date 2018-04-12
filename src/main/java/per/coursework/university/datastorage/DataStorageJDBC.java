package per.coursework.university.datastorage;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;

@Component
public class DataStorageJDBC {
    private static final String url = "jdbc:mysql://localhost:3306/information_system_of_the_university";
    private static final String login = "root";
    private static final String password = "619000619";

    Connection connection;
    Statement statement;

    @PostConstruct
    void init() throws SQLException {
        connection = DriverManager.getConnection(url,login,password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return statement.executeUpdate(query);
    }

    public DataStorageJDBC(){}
}
