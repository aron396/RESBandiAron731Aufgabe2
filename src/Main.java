import Controller.CharakterController;
import Controller.ProduktController;
import Repository.CharakterRepository;
import Repository.ProduktRepository;
import View.ConsoleView;


public class Main {
    public static void main(String[] args) {
        ProduktRepository produktRepository = new ProduktRepository();
        ProduktController produktController = new ProduktController(produktRepository);
        CharakterRepository charakterRepository = new CharakterRepository();
        CharakterController charakterController = new CharakterController(charakterRepository);

        ConsoleView consoleView = new ConsoleView(charakterController, produktController);
        consoleView.showMenu();
    }
}