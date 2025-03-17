package controller;

import view.Text;

public class MainController implements Controller {

    private Text text;

    public MainController() {
        text = new Text();
    }

    @Override
    public void abrirView() {
        text.mainMenu();
    }
}
