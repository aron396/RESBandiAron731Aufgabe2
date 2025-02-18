package View;

import Controller.CharakterController;
import Controller.ProduktController;
import Model.Produkt;

import java.util.Scanner;

public class ConsoleView {

    private CharakterController charakterController;
    private ProduktController produktController;
    private Scanner scanner;

    public ConsoleView(CharakterController charakterController, ProduktController produktController) {
        this.charakterController = charakterController;
        this.produktController = produktController;
        this.scanner = new Scanner(System.in);
    }

    private void addProdukt() {
        System.out.print("Produktname: ");
        String name = scanner.nextLine();
        System.out.print("Preis: ");
        double preis = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Herkunftsregion: ");
        String herkunftsregion = scanner.nextLine();

        produktController.addProdukt(name, preis, herkunftsregion);
        System.out.println("Produkt erfolgreich hinzugefügt.");
    }

    private void showProdukt() {
        System.out.print("Produktname: ");
        String name = scanner.nextLine();
        Produkt produkt = produktController.getProduktByName(name);
        if (produkt != null) {
            System.out.println("Produkt gefunden: " + produkt.getName() + ", Preis: " + produkt.getPreis() + ", Herkunft: " + produkt.getHerkunftsregion());
        } else {
            System.out.println("Produkt nicht gefunden.");
        }
    }

    private void updateProduct() {
        System.out.print("Produktname zum Aktualisieren: ");
        String oldName = scanner.nextLine();
        System.out.print("Neuer Name: ");
        String newName = scanner.nextLine();
        System.out.print("Neuer Preis: ");
        double newPreis = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Neue Herkunftsregion: ");
        String newHerkunftsregion = scanner.nextLine();

        produktController.updateProdukt(oldName, newName, newPreis, newHerkunftsregion);
        System.out.println("Produkt erfolgreich aktualisiert.");
    }

    private void deleteProdukt() {
        System.out.print("Produktname zum Löschen: ");
        String name = scanner.nextLine();
        produktController.deleteProdukt(name);
        System.out.println("Produkt erfolgreich gelöscht.");
    }

    private void showAllProdukte() {
        System.out.println("\n--- Alle Produkte ---");
        for (Produkt p : produktController.getAllProdukte()) {
            System.out.println(p.getName() + " - " + p.getPreis() + " - " + p.getHerkunftsregion());
        }
    }

}
