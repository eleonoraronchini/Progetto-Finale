package ProgettoFInale.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    @Column(nullable = false, name = "data_check_in")
    private LocalDate dataArrivo;
    @Column(nullable = false, name = "data_check_out")
    private LocalDate dataPartenza;

    private String stato; //confermato,annullato
}
