package ProgettoFInale.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "pacchetti_completi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pacchetto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double prezzo;
    private LocalDate dateDisponibili;
    @ManyToOne
    @JoinColumn(name = "volo_id")
    private Volo volo;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
