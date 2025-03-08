package ProgettoFInale.service;

import ProgettoFInale.mapper.DestinazioneMapper;
import ProgettoFInale.model.Destinazione;
import ProgettoFInale.model.Hotel;
import ProgettoFInale.payload.DestinazioneDTO;
import ProgettoFInale.payload.HotelDTO;
import ProgettoFInale.repository.DestinazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DestinazioneService {
    @Autowired
    DestinazioneRepository repository;
    @Autowired
    DestinazioneMapper mapper;

    public List<DestinazioneDTO> getAllDestinazioni() {
        List<Destinazione> lista = repository.findAll();
        List<DestinazioneDTO> listaDTO = new ArrayList<>();
        for (Destinazione destinazione : lista) {
            listaDTO.add(mapper.toDto(destinazione));
        }
        return listaDTO;
    }
}

