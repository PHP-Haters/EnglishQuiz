package controller;

import java.util.Scanner;
import view.Text;
import view.LevelText;

public class LevelController implements Controller {
    private Scanner scanner = new Scanner(System.in);
    Text text = new Text();
    LevelText levelText = new LevelText();

    public void entrandoNaTrilha() {
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
            default:
                entrandoNaTrilha();
                break;
        }
    }

    private void iniciarLevel(){}
    
    @Override
    public void abrirView() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'abrirView'");
    }
    
}
