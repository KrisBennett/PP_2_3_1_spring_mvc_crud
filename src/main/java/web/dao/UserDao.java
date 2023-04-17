package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    User getUserById(Long id);

}
