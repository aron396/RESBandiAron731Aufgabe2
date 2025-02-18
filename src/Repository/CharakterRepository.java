package Repository;

import Model.Charakter;

import java.util.ArrayList;
import java.util.List;

public class CharakterRepository {
    private List<Charakter> charakters = new ArrayList<>();

    public void addCharakter(Charakter charakter) {
        charakters.add(charakter);
    }

    public void deleteCharakter(int id) {
        charakters.removeIf(c -> c.getId() == id);
    }

    public void updateCharakter(int id, Charakter updatedCharakter) {
        for (int i = 0; i < charakters.size(); i++) {
            if (charakters.get(i).getId() == id) {
                charakters.set(i, updatedCharakter);
                return;
            }
        }
    }

    public List<Charakter> getAllCharakters() {
        return charakters;
    }

    public Charakter getCharakterById(int id) {
        return charakters.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
