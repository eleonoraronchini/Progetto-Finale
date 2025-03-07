package ProgettoFInale.mapper;

import ProgettoFInale.model.Destinazione;
import ProgettoFInale.payload.DestinazioneDTO;
import org.springframework.stereotype.Component;

@Component
public class DestinazioneMapper {
    public DestinazioneDTO toDto (Destinazione destinazione){
        DestinazioneDTO destinazioneDTO = new DestinazioneDTO();
        destinazioneDTO.setNome(destinazione.getNome());
        destinazioneDTO.setDescrizione(destinazione.getDescrizione());
        destinazioneDTO.setCategoria(destinazione.getCategoria());
        destinazioneDTO.setImmagine(destinazione.getImmagine());
        return destinazioneDTO;
    }

    public Destinazione toEntity (DestinazioneDTO destinazioneDTO){
        Destinazione destinazione = new Destinazione();
        destinazione.setNome(destinazioneDTO.getNome());
        destinazione.setDescrizione(destinazioneDTO.getDescrizione());
        destinazione.setCategoria(destinazioneDTO.getCategoria());
        destinazione.setImmagine(destinazioneDTO.getImmagine());
        return destinazione;
    }
}
