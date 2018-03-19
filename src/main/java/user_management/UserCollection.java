package user_management;


import user_management.security.*;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        User storedUser = null;
        for (User user:this) {
            if (user.getEmail().equals(email)){
                storedUser = user;
            }
        }

        if (storedUser == null){
            throw new UserAuthenticationFailedException();
        } else if (storedUser.getPassword().matches(password)){
            return storedUser;
        } else {
            throw new UserAuthenticationFailedException();
        }
    }

    public int createUser(String name, String email, String password) throws EmailNotAvailableException,
            InvalidEmailException, PasswordTooSimpleException{
        emailAvailabilityChecker(email);
        validEmailChecker(email);
        validPasswordChecker(password);
        int id = findNextAvailableId();
        this.add(new User(id, name, email, password));
        return id;
    }

    private int findNextAvailableId() {
        int id = 1;
        ArrayList<Integer> idNumberList = new ArrayList<>();
        for (User user:this) {
            idNumberList.add(user.getId());
        }
        Collections.sort(idNumberList);
        for (Integer idNumber: idNumberList) {
            if (id == idNumber){
                id++;
            }
        }
        return id;
    }

    private void validPasswordChecker(String password) throws PasswordTooSimpleException {
        Pattern passwordNumberPattern = Pattern.compile("\\d");
        Matcher paswordNumberMacther = passwordNumberPattern.matcher(password);
        Pattern passwordCharacterPattern = Pattern.compile("[^\\w]");
        Matcher passwordCharacterMacther = passwordCharacterPattern.matcher(password);
        if (password.length() < 8){
            throw new PasswordTooSimpleException();
        } else if (password.equals(password.toLowerCase())){
            throw new PasswordTooSimpleException();
        } else if (password.equals(password.toUpperCase())){
            throw new PasswordTooSimpleException();
        } else if (!paswordNumberMacther.find(0)){
            throw new PasswordTooSimpleException();
        } else if (!passwordCharacterMacther.find(0)){
            throw new PasswordTooSimpleException();
        }
    }

    private void validEmailChecker(String email) throws InvalidEmailException {
        Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,6})$");
        Matcher emailMatcher = emailPattern.matcher(email);
        if (!emailMatcher.find(0)){
            throw new InvalidEmailException();
        }
    }

    private void emailAvailabilityChecker(String email) throws EmailNotAvailableException {
        for (User user: this) {
            if (user.getEmail().equals(email)){
                throw new EmailNotAvailableException();
            }
        }
    }
}
