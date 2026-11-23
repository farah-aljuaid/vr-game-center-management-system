
package interfaces;

/**
 * Borrowable (INTERFACE)
 * - This interface defines actions that any "borrowable" item must support.
 * - In My project, games can be checked out (when a member reserves them)
 *   and checked in (when the session ends).
 */

public interface Borrowable {
    
    void checkOut();
    void checkIn();
}
