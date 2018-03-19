package user_management;

import user_management.security.UserAuthenticationFailedException;

import java.util.ArrayList;

public class UserCollection extends ArrayList<User>{

    public User findById(int id) {
        for (User user: this) {
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        for (User user: this) {
            if (user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException{

        return null;
    }

    public int createUser(String name, String email, String password) {
        return 0;
    }
}
