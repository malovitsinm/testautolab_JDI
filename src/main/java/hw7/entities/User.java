package hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {

    final static public User PITER = new User("epam", "1234", "PITER CHAILOVSKII");

    final private String login;
    final private String password;
    final private String name;
}
