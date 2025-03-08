package ProgettoFInale.controller;

import ProgettoFInale.model.Prenotazione;
import ProgettoFInale.payload.PrenotazioneDTO;
import ProgettoFInale.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {
    @Autowired
    PrenotazioneService service;

   @PostMapping("/createPrenotazione")
    @ResponseStatus(HttpStatus.CREATED)
    public String createPrenotazione(@RequestBody PrenotazioneDTO prenotazioneDTO) {
       PrenotazioneDTO p = service.createPrenotazione(prenotazioneDTO);
       return "Prenotazione aggiunta con succeso!";
   }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Long id) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(id);
        if (prenotazione != null) {
            service.deletePrenotazione(prenotazione);
            return "Prenotazione rimossa";
        }
        return "Prenotazione non trovata";

    }
}
