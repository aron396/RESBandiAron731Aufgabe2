package Model;

import java.util.List;

public class Charakter {

    private int id;
    private String name;
    private String herkunftsdorf;
    private List<Produkt> gekaufteProdukte;

    public Charakter(int id, String name, String herkunftsdorf, List<Produkt> gekaufteProdukte) {
        this.id = id;
        this.name = name;
        this.herkunftsdorf = herkunftsdorf;
        this.gekaufteProdukte = gekaufteProdukte;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHerkunftsdorf() {
        return herkunftsdorf;
    }

    public List<Produkt> getGekaufteProdukte() {
        return gekaufteProdukte;
    }
}
