package ProgettoFInale.mapper;

import ProgettoFInale.model.Hotel;
import ProgettoFInale.payload.HotelDTO;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {
    public HotelDTO toDto (Hotel hotel){
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setNome(hotel.getNome());
        hotelDTO.setDestinazione(hotel.getDestinazione());
        hotelDTO.setDescrizione(hotel.getDescrizione());
        hotelDTO.setStato(hotel.getStato());
        hotelDTO.setPrezzoPerNotte(hotel.getPrezzoPerNotte());
        hotelDTO.setImmagine(hotel.getImmagine());
        return hotelDTO;
    }

    public Hotel toEntity (HotelDTO hotelDTO){
        Hotel hotel = new Hotel();
        hotel.setNome(hotelDTO.getNome());
        hotel.setDestinazione(hotelDTO.getDestinazione());
        hotel.setDescrizione(hotelDTO.getDescrizione());
        hotel.setStato(hotelDTO.getStato());
        hotel.setPrezzoPerNotte(hotelDTO.getPrezzoPerNotte());
        hotel.setImmagine(hotelDTO.getImmagine());
        return hotel;
    }
}
