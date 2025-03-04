package ProgettoFInale.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ProgettoFInale.model.enumerations.Disponibilita;

import java.time.LocalDate;

@Entity(name = "voli")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Volo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "compagnia_aerea", nullable = false)
    private String compagniaArea;
    @Column (nullable = false)
    private double prezzo;
    @Column(name = "data_partenza", nullable = false)
    private LocalDate dataPartenza;
    @Column(name = "data_arrivo", nullable = false)
    private LocalDate dataArrivo;
    @Enumerated(EnumType.STRING)
    private Disponibilita stato;
    @ManyToOne
    @JoinColumn(name = "destinazione_id", nullable = false)
    private Destinazione destinazione;
}
