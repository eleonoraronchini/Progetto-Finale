package ProgettoFInale.mapper;

import ProgettoFInale.model.Prenotazione;
import ProgettoFInale.payload.PrenotazioneDTO;
import ProgettoFInale.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrenotazioneMapper {

    public PrenotazioneDTO toDto (Prenotazione prenotazione){
        PrenotazioneDTO prenotazioneDTO = new PrenotazioneDTO();
        prenotazioneDTO.setHotel(prenotazione.getHotel());
        prenotazioneDTO.setStato(prenotazione.getStato());
        prenotazioneDTO.setUtente(prenotazione.getUtente());
        prenotazioneDTO.setDataArrivo(prenotazione.getDataArrivo());
        prenotazioneDTO.setDataPartenza(prenotazione.getDataPartenza());
        return prenotazioneDTO;
    }

    public Prenotazione  toEntity (PrenotazioneDTO prenotazioneDTO) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setHotel(prenotazioneDTO.getHotel());
        prenotazione.setStato(prenotazioneDTO.getStato());
        prenotazione.setUtente(prenotazioneDTO.getUtente());
        prenotazione.setDataArrivo(prenotazioneDTO.getDataArrivo());
        prenotazione.setDataPartenza(prenotazioneDTO.getDataPartenza());
        return prenotazione;
    }

}
