package Repository;

import Model.Produkt;

import java.util.ArrayList;
import java.util.List;

public class ProduktRepository {
    private List<Produkt> produkts = new ArrayList<>();

    public void addProdukt(Produkt produkt) {
        produkts.add(produkt);
    }

    public void deleteProdukt(String name) {
        produkts.removeIf(p -> p.getName().equalsIgnoreCase(name));
    }

    public void updateProdukt(String name, Produkt updatedProduct) {
        for (int i = 0; i < produkts.size(); i++) {
            if (produkts.get(i).getName().equalsIgnoreCase(name)) {
                produkts.set(i, updatedProduct);
                return;
            }
        }
    }

    public List<Produkt> getAllProdukts() {
        return produkts;
    }

    public Produkt getProduktByName(String name) {
        return produkts.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}
