package view;

public abstract class Text {
    public void limparConsole() {
        System.out.print("\033[H\033[2J");
    }

    public void mensagemDeErroGenerico(String message) {
        System.out.println("\n");
        System.out.println("-----------------");

        if(message != ""){
            System.out.println(message);
        } else {
            System.out.println("Algo deu errado!");
        }

        System.out.println("-----------------");
        System.out.println("\n");
    }
}
