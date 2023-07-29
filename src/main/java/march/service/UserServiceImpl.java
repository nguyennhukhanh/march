package march.service;

import jakarta.persistence.EntityNotFoundException;
import march.enums.Message;
import march.model.User;
import march.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository=userRepository;
        this.modelMapper= modelMapper;
    }


    public List<User> getAll(){
        return this.userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return this.userRepository.findById(id);
    }

    public String saveUser(User user){
        this.userRepository.save(user);
        return Message.SAVE_SUCCESSFULLY;
    }

    public String deleteUser(Long id) {
        User user = this.userRepository.findById(id).orElse(null);
        if (user != null) {
            this.userRepository.delete(user);
            return Message.DELETE_SUCCESSFULLY(user.getFullName());
        } else {
            return Message.DELETION_FAILED;
        }
    }

    public String deleteUsers() {
        this.userRepository.deleteAll();
        return Message.DELETED_ALL_SUCCESSFULLY;
    }

    public User updateUserById(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        modelMapper.map(user, existingUser);
        return userRepository.save(existingUser);
    }

}