package Controller;

import Model.Charakter;
import Model.Produkt;
import Repository.CharakterRepository;

import java.util.List;

public class CharakterController {

    private CharakterRepository charakterRepo;

    public CharakterController(CharakterRepository charakterRepo) {
        this.charakterRepo = charakterRepo;
    }

    public void addCharakter(int id, String name, String herkunftsdorf, List<Produkt> gekaufteProdukte) {
        charakterRepo.addCharakter(new Charakter(id, name, herkunftsdorf, gekaufteProdukte));
    }

    public void deleteCharakter(int id) {
        charakterRepo.deleteCharakter(id);
    }

    public void updateCharakter(int id, String newName, String newHerkunftsdorf, List<Produkt> newGekaufteProdukte) {
        Charakter updatedCharakter = new Charakter(id, newName, newHerkunftsdorf, newGekaufteProdukte);
        charakterRepo.updateCharakter(id, updatedCharakter);
    }

    public List<Charakter> getAllCharakters() {
        return charakterRepo.getAllCharakters();
    }

    public Charakter getCharakterById(int id) {
        return charakterRepo.getCharakterById(id);
    }
}
