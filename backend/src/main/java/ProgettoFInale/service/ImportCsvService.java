package ProgettoFInale.service;

import ProgettoFInale.model.Destinazione;
import ProgettoFInale.model.Hotel;
import ProgettoFInale.model.enumerations.Disponibilita;
import ProgettoFInale.repository.DestinazioneRepository;
import ProgettoFInale.repository.HotelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;


@Service
@RequiredArgsConstructor
public class ImportCsvService {
    private final DestinazioneRepository destinazioneRepository;
    private final HotelRepository hotelRepository;

    @Transactional
    public void importDestinazioni (String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null){
            String[] data = line.split(";");
            if (data.length >= 4){
                Destinazione destinazione = new Destinazione();
                destinazione.setNome(data[0].trim());
                destinazione.setDescrizione(data[1].trim());
                destinazione.setCategoria(data[2].trim());
                destinazione.setImmagine(data[3].trim());
                destinazioneRepository.save(destinazione);
            }
        } System.out.println("Tabella destinazioni importata");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void importHotel (String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null){
                String[] data = line.split(";");
                if (data.length >= 6){
                    Hotel hotel = new Hotel();
                   hotel.setNome(data[0].trim());
                   hotel.setPrezzoPerNotte(Double.parseDouble(data[1].trim()));
                   hotel.setStato(Disponibilita.valueOf(data[2].trim()));
                   hotel.setDescrizione(data[3].trim());
                   hotel.setImmagine(data[4].trim());
                   Long destinazioneId = Long.parseLong(data[5].trim());  // Converti l'ID a Long

                    // Recupera l'entità Destinazione dal repository
                    Destinazione destinazione = destinazioneRepository.findById(destinazioneId).orElseThrow(() ->
                            new RuntimeException("Destinazione non trovata con ID: " + destinazioneId));

                    hotel.setDestinazione(destinazione);  // Imposta l'oggetto destinazione
                   hotelRepository.save(hotel);
                   ;
                }
            } System.out.println("Tabella hotel importata");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
