package view;

public class LoginText extends Text{
    public void entrandoNoSistema() {
        System.out.println("-----------------");
        System.out.println("1. Login"); 
        System.out.println("2. Registrar");
        System.out.println("-----------------");
    }
    public void pedirEmail() {
        System.out.println("-----------------");
        System.out.println("Escreva seu email. Para voltar, digite 0.");
        System.out.println("Email:");
    }
    public void pedirSenha() {
        System.out.println("-----------------");
        System.out.println("Senha:");
    }
    public void senhaPrecisa() {
        System.out.println("-----------------");
        System.out.println("A senha precisa de pelo menos 8 carateres.");
    }
    
    public void jaExiste() {
        System.out.println("-----------------");
        System.out.println("Usuário já existe.");
        System.out.println("-----------------");
        System.out.println("\n");
    }
}
