package Dao;

import User.User;

import java.util.List;

public interface UserInfoDao {
    boolean addUser(User user);
    List<User> showAllUser();

}
