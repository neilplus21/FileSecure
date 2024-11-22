package service;
import dao.userdao;
import model.user;

import java.sql.SQLException;

public class userservice {
    public static Integer saveuser(user user){
        try{
            if(userdao.isExists(user.getEmail())){
                return 0;
            }else{
                userdao.saveUser(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
