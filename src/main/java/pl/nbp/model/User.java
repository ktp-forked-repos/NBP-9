package pl.nbp.model;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @author kelthuzad
 * This class is basic to make instance User
 */
@Getter
@ToString
public class User {
    private int id = 0;
    private String firstName;
    private String lastName;
    private String login;
    private String password;

    /**
     * Constructor User which take values from object UserBuilder
     *
     * @param userBuilder have all field the same which have User
     */
    private User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.login = userBuilder.login;
        this.password = userBuilder.password;
    }

    /**
     * This class is to create another instance like to User and send this value to object User.
     * This is a design pattern Build
     */
    public static class UserBuilder {
        private int id;
        private String firstName = "null";
        private String lastName = "null";
        private String login = "null";
        private String password = "null";

        public UserBuilder id(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder login(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            User user = new User(this);
            return user;
        }
    }
}
