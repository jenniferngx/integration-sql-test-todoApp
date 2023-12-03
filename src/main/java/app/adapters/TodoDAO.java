package app.adapters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.ports.TodoRepository;

public class TodoDAO implements TodoRepository{
    private Connection connection;
    private String username;

    public TodoDAO(Connection connection){
        this.connection = connection;
    }
    

    public List<String> retrieveTodos(String username){
        this.username = username;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from todos where username = '" + username + "'");

            ResultSet rs = ps.executeQuery();

            List<String> allTodos = new ArrayList<>();
            while (rs.next()) {
                allTodos.add(new String(rs.getString("todo")));
            }

            return allTodos;

        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

	public boolean addTodo(String username, String newTodo){
        this.username = username;
        try {
            PreparedStatement ps = connection.prepareStatement("insert into todos values ('" + username + "','" + newTodo + "')");

            return ps.executeUpdate() == 1;


        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void completeTodo(String todo){
        try {
          PreparedStatement ps = connection.prepareStatement("delete from todos where username = '" + username + "' and todo ='" + todo + "'");
          ps.executeUpdate();
     
        } catch(Exception e) {
          throw new RuntimeException(e);
        }
     }
}
