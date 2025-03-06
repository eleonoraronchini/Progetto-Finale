package ProgettoFInale.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "destinazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destinazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(length = 1024)
    private String descrizione;
    @Column(nullable = false)
    private String categoria;
    private String immagine;

}
