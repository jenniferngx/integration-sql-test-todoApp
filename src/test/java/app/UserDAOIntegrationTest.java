package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.api.Test;
// import static org.assertj.core.api.Assertions.*;

import app.adapters.UserDAO;

public class UserDAOIntegrationTest extends SQLIntegrationTestBase{

    UserDAO dao;

    @BeforeEach
    void setup() throws SQLException{
        super.setup();
        dao = new UserDAO(connection);
    }

    @AfterEach
    void cleanup() throws SQLException{
        super.cleanup();
    }

    @Test
    void testAddUser() {
        assertTrue(dao.addUser(userId, username));
    }

    @Test
    void testFindUsernameById(){
        dao.addUser(userId, username);
        String user = dao.findUsernameById(userId);
        assertEquals(username, user);
    }

    @Test
    void testRuntime(){
        assertThrows(RuntimeException.class, () -> dao.findUsernameById(userId).isEmpty());
    }




    
}
