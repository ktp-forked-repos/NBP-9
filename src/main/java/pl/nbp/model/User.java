package pl.nbp.model;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;

    private User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.login = userBuilder.login;
        this.password = userBuilder.password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static class UserBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private String login;
        private String password;

        public UserBuilder id(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public UserBuilder login(String login){
            this.login = login;
            return this;
        }

        public UserBuilder password(String password){
            this.password = password;
            return this;
        }

        public User build(){
            User user = new User(this);
            return user;
        }
    }
}
