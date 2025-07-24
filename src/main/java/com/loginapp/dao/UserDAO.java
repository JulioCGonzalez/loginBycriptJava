package com.loginapp.dao;

import com.loginapp.model.User;
import com.loginapp.util.PasswordUtil;

import java.sql.*;

public class UserDAO {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/loginapp";
    private final String jdbcUsername = "root"; // cambia según tu entorno
    private final String jdbcPassword = "tu_contraseña"; // cambia según tu entorno

    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM usuarios WHERE email = ?";

    public User authenticateUser(String email, String password) {
        User user = null;

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL)) {

            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password_hash");

                if (PasswordUtil.checkPassword(password, hashedPassword)) {
                    user = new User(rs.getInt("id"), rs.getString("email"), hashedPassword);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
