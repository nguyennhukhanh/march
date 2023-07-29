package march.controller;

import march.model.User;
import march.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("manager")
public class UserController{

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("get-all")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("user")
    public Optional<User> getUserById(@RequestParam("id") Long id) {
        return this.userService.getUserById(id);
    }

    @PostMapping("save")
    public String saveUser(User user) {
        return this.userService.saveUser(user);
    }

    @DeleteMapping("delete")
    public String deleteUser(@RequestParam("id") Long id) {
        return this.userService.deleteUser(id);
    }

    @DeleteMapping("delete-all")
    public String deleteUsers() {
        return this.userService.deleteUsers();
    }

    @PatchMapping(value="update/{id}")
    public User updateUserById(@PathVariable Long id, User user) {
        return userService.updateUserById(id, user);
    }
}