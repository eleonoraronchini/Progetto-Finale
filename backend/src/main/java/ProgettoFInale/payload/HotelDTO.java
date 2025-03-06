package ProgettoFInale.payload;

import ProgettoFInale.model.Destinazione;
import ProgettoFInale.model.enumerations.Disponibilita;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HotelDTO {
    @NotBlank(message = "il campo nome non può essere vuoto")
    private String nome;

    @NotNull(message = "il campo prezzo per notte non può essere vuoto")
    private double prezzoPerNotte;

    @Enumerated(EnumType.STRING)
    private Disponibilita stato;

    private String descrizione;

    private String immagine;

    @NotBlank(message = "il campo destinazione non può essere vuoto")
    private Destinazione destinazione;
}
