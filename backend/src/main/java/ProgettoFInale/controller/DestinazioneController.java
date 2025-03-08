package ProgettoFInale.controller;

import ProgettoFInale.model.Destinazione;
import ProgettoFInale.payload.DestinazioneDTO;
import ProgettoFInale.service.DestinazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/destinazione")
public class DestinazioneController {
    @Autowired
    DestinazioneService service;

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DestinazioneDTO> getAllDestinazioni() {
        return service.getAllDestinazioni();
    }
}
