package n.w.RepoDetailsAPI.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User with given id not found.");
    }
}