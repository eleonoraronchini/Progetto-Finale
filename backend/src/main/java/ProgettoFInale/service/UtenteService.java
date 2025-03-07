package ProgettoFInale.service;

import ProgettoFInale.mapper.UtenteMapper;
import ProgettoFInale.model.Utente;
import ProgettoFInale.payload.UtenteDTO;
import ProgettoFInale.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
