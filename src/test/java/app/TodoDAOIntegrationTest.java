package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
// import java.util.List;
// import static org.assertj.core.api.Assertions.*;
// import org.junit.jupiter.api.Test;

import app.adapters.TodoDAO;


class TodoDAOIntegrationTest extends SQLIntegrationTestBase{
	// TodoDAO dao;

	@Test
	void testAddTodo() {
        String task1 = "Find all the infinity stones.";
		String task2 = "Snap your fingers.";
		String task3 = "Save the world.";

        todo.addTodo(username, task1);
		List<String> list = todo.retrieveTodos(username);
        assertThat(list).containsExactlyInAnyOrder(task1);

		todo.addTodo(username, task2);
		List<String> list2 = todo.retrieveTodos(username);
        assertThat(list2).containsExactlyInAnyOrder(task1, task2);

		todo.addTodo(username, task3);
		List<String> list3 = todo.retrieveTodos(username);
        assertThat(list3).containsExactlyInAnyOrder(task1,task2,task3);
    }


	@Test
	void testCompleteTodo() {

        todo.addTodo(username, "task1");
		todo.addTodo(username, "task2");

        todo.completeTodo("task1");
		List<String> list1 = todo.retrieveTodos(username);
		assertThat(list1).doesNotContain("task1");

		todo.completeTodo("task2");
		List<String> list2 = todo.retrieveTodos(username);
		assertThat(list2).doesNotContain("task2");
    }
}
