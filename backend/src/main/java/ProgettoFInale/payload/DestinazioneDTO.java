package ProgettoFInale.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class DestinazioneDTO {
    @NotBlank(message = "il campo nome non può essere vuoto" )
    private String nome;

    @NotBlank(message = "il campo descrizione non può essere vuoto")
    private String descrizione;

    private String categoria;

    @URL
    private String immagine;

}

