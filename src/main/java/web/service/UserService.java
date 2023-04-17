package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    User getUserById(Long id);

}
