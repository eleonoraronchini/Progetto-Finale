package ProgettoFInale.controller;

import ProgettoFInale.payload.HotelDTO;
import ProgettoFInale.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService service;

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<HotelDTO> getAllDipendenti() {
        return service.getAllHotel();
    }
}
