package Repository;

import Model.Charakter;

import java.util.ArrayList;
import java.util.List;

public class CharakterRepository {
    private List<Charakter> charaktere = new ArrayList<>();

    public void addCharakter(Charakter charakter) {
        charaktere.add(charakter);
    }

    public void deleteCharakter(int id) {
        charaktere.removeIf(c -> c.getId() == id);
    }

    public void updateCharakter(int id, Charakter updatedCharakter) {
        for (int i = 0; i < charaktere.size(); i++) {
            if (charaktere.get(i).getId() == id) {
                charaktere.set(i, updatedCharakter);
                return;
            }
        }
    }

    public List<Charakter> getAllCharaktere() {
        return charaktere;
    }

    public Charakter getCharakterById(int id) {
        return charaktere.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
