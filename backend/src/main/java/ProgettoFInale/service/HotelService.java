package ProgettoFInale.service;

import ProgettoFInale.mapper.HotelMapper;
import ProgettoFInale.model.Hotel;
import ProgettoFInale.payload.HotelDTO;
import ProgettoFInale.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelRepository repository;
    @Autowired
    HotelMapper mapper;

    public List<HotelDTO> getAllHotel() {
        List<Hotel> lista = repository.findAll();
        List<HotelDTO> listaDTO = new ArrayList<>();
        for (Hotel hotel : lista) {
            listaDTO.add(mapper.toDto(hotel));
        }
        return listaDTO;
    }

}
