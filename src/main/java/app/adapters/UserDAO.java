package app.adapters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import app.ports.UserRepository;

public class UserDAO implements UserRepository{

    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addUser(Long id, String username){
        try {
            PreparedStatement ps = connection.prepareStatement("insert into users values (" + id + ",'" + username + "')");

            return ps.executeUpdate() == 1;


        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String findUsernameById(Long id){
        try {
            PreparedStatement ps = connection.prepareStatement("select * from users where id = " + Long.toString(id));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("username");
            }

        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        throw new RuntimeException("Database did not return a result");
    }
}
