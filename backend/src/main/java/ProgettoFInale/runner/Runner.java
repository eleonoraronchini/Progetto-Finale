package ProgettoFInale.runner;

import ProgettoFInale.service.ImportCsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    ImportCsvService importCsvService;

    @Override
    public void run(String... args) throws Exception {
        importCsvService.importDestinazioni("src/main/resources/destinazioni.csv");
        System.out.println("✅ Importazione destinazioni completata!");
        importCsvService.importHotel("src/main/resources/hotel.csv");
        System.out.println("✅ Importazione hotel completata!");

    }
}
