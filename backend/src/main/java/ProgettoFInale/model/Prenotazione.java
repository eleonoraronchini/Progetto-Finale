package ProgettoFInale.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "prenotazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "volo_id")
    private Volo volo;
    @ManyToOne
    @JoinColumn(name = "pacchetto_id")
    private Pacchetto pacchetto;
    private String stato; //confermato,annullato
}
