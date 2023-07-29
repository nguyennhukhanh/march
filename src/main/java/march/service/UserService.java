package march.service;

import march.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAll();
    Optional<User> getUserById(Long id);
    String saveUser(User user);
    String deleteUser(Long id);
    String deleteUsers();
    User updateUserById(Long id, User user);
}