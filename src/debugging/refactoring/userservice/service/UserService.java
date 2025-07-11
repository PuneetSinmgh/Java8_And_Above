package src.debugging.refactoring.userservice.service;



import src.debugging.refactoring.userservice.model.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class UserService {
    private final ConcurrentHashMap<String, User> concurrentMap = new ConcurrentHashMap<>(); // using concurrent map to remove multithreading issue

    // Email validation pattern
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    private final Random random = new Random();

    /**
     * Registers a new user.
     *
     * @param name  Name of the user (non-null)
     * @param email Valid email address (unique)
     * @return The generated unique username
     * @throws IllegalArgumentException if input is invalid or email already exists
     */
    public String registerUser(String name, String email) {

        validateInputParams( name , email);


        String username = generateUniqueUsername(name);

        // before adding perform duplicate check on email
        if ( concurrentMap.containsKey( email )){
            throw new IllegalArgumentException("Email already exists");
        }
        concurrentMap.put( email , new User(name, email, username)); // separate creational design pattern can be used for creation of User

        return username;
    }

    // input param validaiton
    private void validateInputParams(String name, String email){

        if ( name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException( " Name cannot be empty");
        }

        if (email == null || !EMAIL_PATTERN.matcher(email).matches() ) {
            throw new IllegalArgumentException( " Email is in invalid format");
        }
    }

    // Unique username generator with collision check
    private String generateUniqueUsername(String name) {

        String base = name.toLowerCase().replaceAll("\\s+", "");
        String username;

        do {
            username = base + random.nextInt(10000);
        } while (!isValidUserName(username));
        return username;
    }

    // custom validation logic
    private boolean isValidUserName(String userName){
        return concurrentMap.values().stream()
                .noneMatch(user -> user.getUsername().equalsIgnoreCase(userName));
    }

    /**
     * get a user by its email.
     *
     *
     * @param email Valid email address of the user
     * @return The generated unique username
     */
    public Optional<User> getUserByEmail(String email) {
        if (email == null )
            return Optional.empty();

        if ( concurrentMap.containsKey(email)){
            return Optional.of(concurrentMap.get(email));
        }
        return Optional.empty();
    }
}