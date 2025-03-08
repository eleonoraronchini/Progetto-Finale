package ProgettoFInale.service;

import ProgettoFInale.mapper.UtenteMapper;
import ProgettoFInale.model.Utente;
import ProgettoFInale.payload.UtenteDTO;
import ProgettoFInale.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UtenteService {
@Autowired
    UtenteRepository repository;
@Autowired
    UtenteMapper mapper;

    public Utente findByEmail(String email){
        return this.repository.findOneByEmail(email).orElseThrow(()->new RuntimeException("email non trovata!"));
    }

    public UtenteDTO createUtente (UtenteDTO utenteDTO){
        if (repository.findOneByEmail(utenteDTO.getEmail()).isPresent()) {
            throw new RuntimeException("L'email è già registrata!");
        }
        Utente utente = mapper.toEntity(utenteDTO);
        repository.save(utente);
        return utenteDTO;
    }
    public UtenteDTO updateUtente(Utente utente) {
        Optional<Utente> utenteRicercato = repository.findById(utente.getId());
        if (utenteRicercato.isPresent()) {
            Utente utenteTrovato = utenteRicercato.get();
            utenteTrovato.setUsername(utente.getUsername());
            utenteTrovato.setNome(utente.getNome());
            utenteTrovato.setCognome(utente.getCognome());
            utenteTrovato.setEmail(utente.getEmail());
            repository.save(utenteTrovato);
            UtenteDTO utenteUpdateDTO = mapper.toDto(utenteTrovato);
            return utenteUpdateDTO;
        } else {
            throw new RuntimeException("nessun utente trovato con questo id");
        }

    }
}
