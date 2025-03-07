package ProgettoFInale.mapper;

import ProgettoFInale.model.Utente;
import ProgettoFInale.payload.UtenteDTO;
import org.springframework.stereotype.Component;

@Component
public class UtenteMapper {
    public UtenteDTO toDto (Utente utente){
        UtenteDTO utenteDTO = new UtenteDTO();
        utenteDTO.setUsername(utente.getUsername());
        utenteDTO.setNome(utente.getNome());
        utenteDTO.setCognome(utente.getCognome());
        utenteDTO.setEmail(utente.getEmail());
        utenteDTO.setPassword(utente.getPassword());
        return utenteDTO;
    }

    public Utente toEntity (UtenteDTO utenteDTO){
        Utente utente = new Utente();
        utente.setUsername(utenteDTO.getUsername());
        utente.setNome(utenteDTO.getNome());
        utente.setCognome(utenteDTO.getCognome());
        utente.setEmail(utenteDTO.getEmail());
        utente.setPassword(utenteDTO.getPassword());
        return utente;
    }
}
