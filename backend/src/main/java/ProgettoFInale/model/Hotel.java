package ProgettoFInale.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ProgettoFInale.model.enumerations.Disponibilita;

@Entity(name = "hotel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private double prezzoPerNotte;
    @Enumerated(EnumType.STRING)
    private Disponibilita stato;
    private String descrizione;
    private String immagine;
    @ManyToOne
    @JoinColumn(name = "destinazione_id", nullable = false)
    private Destinazione destinazione;

}
