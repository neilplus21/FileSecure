package dao;

import database.myconnection;
import model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userdao {
    public static boolean isExists(String email) throws SQLException {
        Connection connection = myconnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("select email from users");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String e = rs.getString(1);
            if (e.equals(email))
                return true;
        }
        return false;
    }
    public static int saveUser(user user) throws SQLException {
        Connection connection = myconnection.getConnection();
        PreparedStatement ps =connection.prepareStatement("insert into users values(default, ?, ?)");
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        return ps.executeUpdate();
    }
}
