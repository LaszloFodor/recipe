package service;


import lombok.Data;
import model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
public class UserService {

    private User user;
}
