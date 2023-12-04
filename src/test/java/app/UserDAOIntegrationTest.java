package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.fail;

// import java.sql.SQLException;

// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.api.Test;
// import static org.assertj.core.api.Assertions.*;


public class UserDAOIntegrationTest extends SQLIntegrationTestBase{
    // UserDAO dao;

    @Test
    void testAddUser() {
        String username2 = "adam";
        Long userId2 = 50L;

        user.addUser(userId, username);
        assertEquals(user.findUsernameById(userId), username);

        user.addUser(userId2, username2);
        assertEquals(user.findUsernameById(userId2), username2);
    }

    @Test
    void testFindUsernameById(){
        user.addUser(userId, username);
        assertEquals(user.findUsernameById(userId), username);

        String username2 = "Jennifer";
        Long userId2 = 10L;
        user.addUser(userId2, username2);
        assertEquals(user.findUsernameById(userId2), username2);

    }
 
}
