package ProgettoFInale.repository;

import ProgettoFInale.model.Destinazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinazioneRepository extends JpaRepository<Destinazione, Long> {
}
