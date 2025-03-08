package ProgettoFInale.payload;

import ProgettoFInale.model.Hotel;
import ProgettoFInale.model.Utente;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PrenotazioneDTO {
    @NotBlank(message = "il campo utente non può essere vuoto")
    private Utente utente;
    @NotBlank(message = "il campo hotel non può essere vuoto")
    private Hotel hotel;
    @NotBlank(message = "specifica una data per il check-in")
    private LocalDate dataArrivo;
    @NotBlank(message = "inserisci una data per il check-out")
    private LocalDate dataPartenza;

    private String stato;
}
