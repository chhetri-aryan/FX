package Dao;

import User.User;
import Util.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserInfoDao {
    @Override
    public boolean addUser(User user) {
        try {
            Connection con  = DbConnection.getConnection();
            Statement stm = con.createStatement();

//            ResultSet rs = stm.executeQuery("Select * from product");
            String sql = "INSERT INTO product (name, price, category) VALUES" +
                    " (" + user.getName() + "," + user.getEmail() + "," + user.getDepartment() + "," + user.getPhone() +");";

            stm.execute(sql);




            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
