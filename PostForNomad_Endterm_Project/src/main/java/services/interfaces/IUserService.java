package services.interfaces;

import entities.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();

    boolean create(User user);

    User get(int id);

    boolean delete(int id);

    User getUserByLogin(String username, String password);

    User getUserByUsername(String issuer);
}
