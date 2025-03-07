package ProgettoFInale.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.EmbeddableInstantiator;

public record LoginDTO (
        @Email(message = "inserire un'indirizzo email valido")
        @NotNull(message = "il campo email non può essere vuoto")
        String email,
        @NotNull(message = "il campo password non può essere vuoto")
        String password
){

}

