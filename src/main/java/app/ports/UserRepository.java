package app.ports;

/**
 * The port that abstracts the operations on the Person table in the database.
 */
public interface UserRepository {
	String findUsernameById(Long id);
}