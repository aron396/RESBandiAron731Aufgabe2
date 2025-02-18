package Controller;

import Model.Produkt;
import Repository.ProduktRepository;

import java.util.List;

public class ProduktController {

    private ProduktRepository produktRepo;

    public ProduktController(ProduktRepository produktRepo) {
        this.produktRepo = produktRepo;
    }

    public void addProdukt(String name, double preis, String herkunftsregion) {
        produktRepo.addProdukt(new Produkt(name, preis, herkunftsregion));
    }

    public void deleteProdukt(String name) {
        produktRepo.deleteProdukt(name);
    }

    public void updateProdukt(String oldName, String newName, double newPreis, String newHerkunftsregion) {
        Produkt updatedProdukt = new Produkt(newName, newPreis, newHerkunftsregion);
        produktRepo.updateProdukt(oldName, updatedProdukt);
    }

    public List<Produkt> getAllProdukte() {
        return produktRepo.getAllProdukte();
    }

    public Produkt getProduktByName(String name) {
        return produktRepo.getProduktByName(name);
    }
}
