package ProgettoFInale.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UtenteDTO {
    @NotBlank(message = "il campo username non può essere vuoto")
    private String username;

    @NotBlank(message = "il campo nome non può essere vuoto")
    private String nome;

    @NotBlank(message = "il campo cognome non può essere vuoto")
    private String cognome;

    @NotBlank(message = "il campo email non può essere vuoto")
    @Email(message = "inserisci un email valida")
    private String email;

   @NotBlank(message = "il campo password non può essere vuoto")
    private String password;
}
