package controller;

import java.util.Scanner;
import view.Text;
import view.LevelText;

public class LevelController implements Controller {
    private Scanner scanner = new Scanner(System.in);
    Text text = new Text();
    LevelText levelText = new LevelText();

    @Override
    public void abrirView() {
        text.limparConsole();
        levelText.entrandoNaTrilha();

        int escolhaDeUsuario = scanner.nextInt(); 

        switch (escolhaDeUsuario) {
            case 1:
                iniciarLevel();
                break;
            case 2:
                iniciarLevel();
                break;
            case 3:
                iniciarLevel();
                break;
            case 0:
                text.limparConsole();
                MainController mainController = new MainController();
                mainController.abrirView();
                break;
            default:
                abrirView();
                break;
        }
    }

    private void iniciarLevel(){}
}
