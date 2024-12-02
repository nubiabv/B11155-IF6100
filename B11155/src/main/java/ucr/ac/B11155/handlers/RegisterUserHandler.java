package ucr.ac.B11155.handlers;

public interface RegisterUserHandler {
    record Command(String name, String email, String password){}
    sealed interface Result{
        final record Success(String message) implements Result{}
        final record invalidData(String...fields) implements Result{}
    }
    void registerUser(Command command);

}
