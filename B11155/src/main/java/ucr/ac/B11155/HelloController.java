package ucr.ac.B11155;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ucr.ac.B11155.handlers.RegisterUserHandler;

@RestController
public class HelloController {

    @Autowired
    private RegisterUserHandler handler;

    @GetMapping("/hello")

    public String hello() {

        var result = handler.registerUser(
                new RegisterUserHandler.Command(
                        "Nubia",
                        "nubia@gmail.com",
                        "password"
                )
        );

        return switch (result) {
            case RegisterUserHandler.Result.Success success ->
                    success.message();
            case RegisterUserHandler.Result.InvalidData invalidData ->
                    "Invalid data: " + String.join(", ", invalidData.fields());
        };
    }
}
