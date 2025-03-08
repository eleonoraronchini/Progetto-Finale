package ProgettoFInale.repository;

import ProgettoFInale.model.Prenotazione;
import ProgettoFInale.model.Utente;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByUtenteAndDataArrivo(Utente utente, LocalDate dataArrivo);
}
