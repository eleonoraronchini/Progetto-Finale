package ProgettoFInale.service;

import ProgettoFInale.mapper.HotelMapper;
import ProgettoFInale.mapper.PrenotazioneMapper;
import ProgettoFInale.mapper.UtenteMapper;
import ProgettoFInale.model.Hotel;
import ProgettoFInale.model.Prenotazione;
import ProgettoFInale.model.Utente;
import ProgettoFInale.payload.HotelDTO;
import ProgettoFInale.payload.PrenotazioneDTO;
import ProgettoFInale.payload.UtenteDTO;
import ProgettoFInale.repository.HotelRepository;
import ProgettoFInale.repository.PrenotazioneRepository;
import ProgettoFInale.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class PrenotazioneService {

    @Autowired
    PrenotazioneMapper mapper;
    @Autowired
    UtenteRepository utenteRepository;
    @Autowired
    UtenteMapper uMapper;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    HotelMapper hMapper;
    @Autowired
    PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneDTO createPrenotazione(PrenotazioneDTO pDTO) {
        Prenotazione p = mapper.toEntity(pDTO);

        // Verifica e recupera o crea l'utente
        Utente u = utenteRepository.findOneByEmail(p.getUtente().getEmail())
                .orElseThrow();
        p.setUtente(u);

        // Verifica e recupera o crea l'hotel
        Hotel h = hotelRepository.findByNome(p.getHotel().getNome())
                .orElseThrow();
        p.setHotel(h);

        // Verifica se l'utente ha già una prenotazione per lo stesso giorno
        boolean prenotazioneEsistente = prenotazioneRepository.existsByUtenteAndDataArrivo(p.getUtente(), p.getDataArrivo());
        if (prenotazioneEsistente) {
            throw new RuntimeException("L'utente ha già una prenotazione per questo giorno.");
        }

        // Salvataggio della prenotazione
        prenotazioneRepository.save(p);

        return mapper.toDto(p);
    }

    public String deletePrenotazione (Prenotazione p){
        Optional<Prenotazione> PrenotazioneRicercata = prenotazioneRepository.findById(p.getId());
        if(PrenotazioneRicercata.isPresent()){
            Prenotazione prenotazioneTrovata = PrenotazioneRicercata.get();
            prenotazioneRepository.delete(prenotazioneTrovata);
            PrenotazioneDTO prenotazioneDTO = mapper.toDto(prenotazioneTrovata);
            return "prenotazione rimossa con successo!";
        }
        return "prenotazione non trovata";
    }
}
