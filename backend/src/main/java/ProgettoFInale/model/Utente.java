package ProgettoFInale.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "utenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column (nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    //gestire ruolo
}
