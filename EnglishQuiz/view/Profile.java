package view;

import model.User;
import server.Session;

public class Profile extends Text{
    public void telaDoUsuario() {
        System.out.println("-----------------");
        System.out.println("1. Mostrar usuário");
        System.out.println("2. Editar email");
        System.out.println("3. Editar senha");
        System.out.println("4. Deletar usuário");
        System.out.println("5. Deslogar");
        System.out.println("-----------------");
        System.out.println("\n\n");
        System.out.println("6. Trilhas");
        System.out.println("-----------------");
    }

    public void mostrarUsuario() {
        User usuarioAtual = Session.getInstance().getLoggedUser();

        System.out.println("-----------------");
        System.out.println("Usuário atual:\n");
        System.out.println("Id: " + usuarioAtual.getId());
        System.out.println("Email: " + usuarioAtual.getEmail());
        System.out.println("Senha: " + usuarioAtual.getPassword());
        System.out.println("-----------------");
    }
}
