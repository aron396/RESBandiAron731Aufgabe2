package View;

import Controller.CharakterController;
import Controller.ProduktController;
import Model.Charakter;
import Model.Produkt;

import java.util.ArrayList;
import java.util.List;
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

    public void showMenu() {
        while (true) {
            System.out.println("\n--- CRUD ---");
            System.out.println("1. Produkt hinzufügen");
            System.out.println("2. Produkt anzeigen");
            System.out.println("3. Produkt aktualisieren");
            System.out.println("4. Produkt löschen");
            System.out.println("5. Alle Produkte anzeigen");
            System.out.println("6. Charakter hinzufügen");
            System.out.println("7. Charakter anzeigen");
            System.out.println("8. Charakter aktualisieren");
            System.out.println("9. Charakter löschen");
            System.out.println("10. Alle Charaktere anzeigen");
            System.out.println("11. Beenden");
            System.out.print("Auswahl: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addProdukt();
                case 2 -> showProdukt();
                case 3 -> updateProdukt();
                case 4 -> deleteProdukt();
                case 5 -> showAllProdukte();
                case 6 -> addCharakter();
                case 7 -> showCharakter();
                case 8 -> updateCharakter();
                case 9 -> deleteCharakter();
                case 10 -> showAllCharaktere();
                case 11 -> {
                    System.out.println("Programm beendet.");
                    return;
                }
                default -> System.out.println("Ungültige Eingabe!");
            }
        }
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

    private void updateProdukt() {
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

    private void addCharakter() {
        System.out.print("Charakter-ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Herkunftsdorf: ");
        String herkunftsdorf = scanner.nextLine();

        List<Produkt> produkte = addProdukteToCharakter();

        charakterController.addCharakter(id, name, herkunftsdorf, produkte);
        System.out.println("Charakter erfolgreich hinzugefügt.");
    }

    private void showCharakter() {
        System.out.print("Charakter-ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Charakter charakter = charakterController.getCharakterById(id);
        if (charakter != null) {
            System.out.println("Charakter gefunden: " + charakter.getName() + ", Herkunft: " + charakter.getHerkunftsdorf());
            System.out.println("Gekaufte Produkte: ");
            for (Produkt p : charakter.getGekaufteProdukte()) {
                System.out.println(" - " + p.getName() + " (Preis: " + p.getPreis() + ", Herkunft: " + p.getHerkunftsregion() + ")");
            }
        } else {
            System.out.println("Charakter nicht gefunden.");
        }
    }

    private void updateCharakter() {
        System.out.print("Charakter-ID zum Aktualisieren: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Neuer Name: ");
        String newName = scanner.nextLine();
        System.out.print("Neuer Herkunftsdorf: ");
        String newHerkunftsdorf = scanner.nextLine();

        List<Produkt> newProdukte = addProdukteToCharakter();

        charakterController.updateCharakter(id, newName, newHerkunftsdorf, newProdukte);
        System.out.println("Charakter erfolgreich aktualisiert.");
    }

    private void deleteCharakter() {
        System.out.print("Charakter-ID zum Löschen: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        charakterController.deleteCharakter(id);
        System.out.println("Charakter erfolgreich gelöscht.");
    }

    private void showAllCharaktere() {
        System.out.println("\n--- Alle Charaktere ---");
        for (Charakter c : charakterController.getAllCharaktere()) {
            System.out.println("ID: " + c.getId() + ", Name: " + c.getName() + ", Herkunft: " + c.getHerkunftsdorf());
            System.out.println("Gekaufte Produkte: ");
            for (Produkt p : c.getGekaufteProdukte()) {
                System.out.println(" - " + p.getName() + " (Preis: " + p.getPreis() + ", Herkunft: " + p.getHerkunftsregion() + ")");
            }
        }
    }

    private List<Produkt> addProdukteToCharakter() {
        List<Produkt> produkte = new ArrayList<>();
        System.out.print("Wie viele Produkte soll der Charakter haben? ");
        int produktCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < produktCount; i++) {
            System.out.print("Produktname: ");
            String produktName = scanner.nextLine();
            System.out.print("Preis: ");
            double preis = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Herkunftsregion: ");
            String herkunftsregion = scanner.nextLine();

            produkte.add(new Produkt(produktName, preis, herkunftsregion));
        }

        return produkte;
    }


}
