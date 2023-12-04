package app;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

// import app.adapters.*;
public class SQLIntegrationTestBase {

    protected Connection connection;
    protected final Long userId = 42L;
	protected final String username = "tony-stark";
	protected List<String> todos = List.of("Find all the infinity stones.", "Snap your fingers.", "Save the world.");
    protected app.adapters.TodoDAO todo;
    protected app.adapters.UserDAO user;


    @BeforeEach
    void setup() throws SQLException {
        connection = DriverManager.getConnection("jdbc:hsqldb:mem:testdb");     
        PreparedStatement users = connection.prepareStatement("CREATE TABLE users (id bigint, username varchar(20))");
        PreparedStatement todos = connection.prepareStatement("CREATE TABLE todos (username varchar(20), todo varchar(100))");
        
        users.execute();
        todos.execute();
        connection.commit();

        todo = new app.adapters.TodoDAO(connection);
        user = new app.adapters.UserDAO(connection);
    }

    @AfterEach
    void cleanup() throws SQLException{
        connection.close();
    }
    
}
