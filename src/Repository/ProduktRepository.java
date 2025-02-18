package Repository;

import Model.Produkt;

import java.util.ArrayList;
import java.util.List;

public class ProduktRepository {
    private List<Produkt> produkte = new ArrayList<>();

    public void addProdukt(Produkt produkt) {
        produkte.add(produkt);
    }

    public void deleteProdukt(String name) {
        produkte.removeIf(p -> p.getName().equalsIgnoreCase(name));
    }

    public void updateProdukt(String name, Produkt updatedProduct) {
        for (int i = 0; i < produkte.size(); i++) {
            if (produkte.get(i).getName().equalsIgnoreCase(name)) {
                produkte.set(i, updatedProduct);
                return;
            }
        }
    }

    public List<Produkt> getAllProdukte() {
        return produkte;
    }

    public Produkt getProduktByName(String name) {
        return produkte.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}
