package ucr.ac.B11155.handlers;

public interface RegisterUserHandler {
    //Entrada
    record Command(String name, String email, String password){

    }
    //Salida
    sealed interface Result{

        record Success(String message) implements Result{

        }
        record InvalidData(String...fields) implements Result{

        }
    }
    //Proceso
    Result registerUser(Command command);

}
