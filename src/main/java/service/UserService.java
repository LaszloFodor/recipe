package service;


import exception.UserNotValidException;
import lombok.Data;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private User user;

    public User login(User user) throws UserNotValidException {
        if(isValid(user)) {
            return this.user = userRepository.findByUsername(user.getUserName());
        }
        throw new UserNotValidException();
    }

    public User register(User user) {
        user.setRole(User.Role.USER);
        this.user = userRepository.save(user);
        return user;
    }

    public boolean isValid(User user) {
        return (userRepository.findByUsernameAndPassword(user.getUserName(), user.getPassword()) instanceof User);
    }

    public boolean isLoggedIn() {
        return user != null;
    }
}
