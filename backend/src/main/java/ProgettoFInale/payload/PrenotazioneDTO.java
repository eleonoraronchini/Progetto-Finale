package ProgettoFInale.payload;

import ProgettoFInale.model.Hotel;
import ProgettoFInale.model.Utente;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PrenotazioneDTO {
    @NotBlank(message = "il campo utente non può essere vuoto")
    private Utente utente;
    @NotBlank(message = "il campo hotel non può essere vuoto")
    private Hotel hotel;

    private String stato;
}
