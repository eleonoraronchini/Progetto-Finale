package ProgettoFInale.repository;

import ProgettoFInale.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Optional<Utente> findOneByEmail(String email);
}
