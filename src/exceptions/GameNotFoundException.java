package exceptions;

/**
 * GameNotFoundException 
 * This class represents a custom exception used when a game cannot be found.
 */

public class GameNotFoundException extends Exception {

    public GameNotFoundException(String message) {
        super(message);
    }
}
