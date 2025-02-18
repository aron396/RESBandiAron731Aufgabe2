package Model;

public class Produkt {

    private String name;
    private double preis;
    private String herkunftsregion;

    public Produkt(String name, double preis, String herkunftsregion) {
        this.name = name;
        this.preis = preis;
        this.herkunftsregion = herkunftsregion;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }

    public String getHerkunftsregion() {
        return herkunftsregion;
    }
}
