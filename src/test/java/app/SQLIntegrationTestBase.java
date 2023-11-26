package app;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SQLIntegrationTestBase {

    protected Connection connection;
    protected final Long userId = 42L;
	protected final String username = "tony-stark";
	protected List<String> todos = List.of("Find all the infinity stones.", "Snap your fingers.", "Save the world.");

    @BeforeEach
    void setup() throws SQLException {
 
    }

    @AfterEach
    void cleanup() throws SQLException{

    }
}
