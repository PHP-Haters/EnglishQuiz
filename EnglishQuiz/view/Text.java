package view;

public abstract class Text {
    public void limparConsole() {
        System.out.print("\033[H\033[2J");
    }  

    public void mensagemDeErroGenerico() {
        System.out.println("\n");
        System.out.println("-----------------");
        System.out.println("Alguma coisa deu errado. Tente de novo");
        System.out.println("-----------------");
        System.out.println("\n");
    }
}
