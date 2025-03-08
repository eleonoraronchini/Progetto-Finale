package ProgettoFInale.repository;

import ProgettoFInale.model.Destinazione;
import ProgettoFInale.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findByNome (String nome);
    Optional<Hotel> findByDestinazioneAndNome (Destinazione destinazione, String nome);
}
