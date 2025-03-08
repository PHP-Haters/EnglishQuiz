package controller;

import java.util.Scanner;

import model.Session;
import model.User;
import service.UserService;
import view.LoginText;
import view.Profile;

public class UserController implements Controlller{

    LoginText loginText;
    Profile profileScreen;
    UserService userService;
    Scanner scanner;
    int escolhaDeUsuario;

    protected UserController() {
        loginText = new LoginText();
        profileScreen = new Profile();
        userService = new UserService();
        scanner = new Scanner(System.in);
    }

    @Override
    public void abrirView() {
        comecarLoginOuRegister();
    }

    //*Aqui ele vai começar o login e decidir se vai pra login ou registrar.
    public void comecarLoginOuRegister() {
        loginText.entrandoNoSistema();
        setarEscolhaNumerica();
        switch (escolhaDeUsuario) {
            case 1:
                inputDoEmailLogin();
                break;
            case 2:
                registerEmailInput();
                break;
            default:
                comecarLoginOuRegister();
                break;
        }
    }

    //*Funções do login
    private void inputDoEmailLogin() {
        String userEmail = emailInput();

        if(retornarPaginaLogin(userEmail))
            return;

        User usuarioEncontrado = userService.verificacaoDeEmail(userEmail);
        if(usuarioEncontrado == null) {
            loginText.mensagemDeErroGenerico("Email incorreto ou usuário inexistente");
            inputDoEmailLogin();
            scanner.close();
            return;
        }
        inputDaSenhaLogin(usuarioEncontrado);
    }

    private void inputDaSenhaLogin(User usuarioEncontrado) {
        String senhaDoUsuario = senhaInput();

        if(retornarPaginaLogin(senhaDoUsuario))
            return;

        if(userService.verificacaoDeSenha(usuarioEncontrado, senhaDoUsuario)) {
            Session.getInstance().setLoggedUser(usuarioEncontrado);
            loginText.limparConsole();
            iniciarSistemaInterno();
        }
        else {
            loginText.mensagemDeErroGenerico("Senha incorreta!");
            inputDaSenhaLogin(usuarioEncontrado);
        }
        scanner.close();
    }

    private void iniciarSistemaInterno(){
        profileScreen.telaDoUsuario();
        setarEscolhaNumerica();
        switch (escolhaDeUsuario) {
            case 1:
                listarUsuarioAtual();
                break;
            case 2:
                // editarUsuario();
                break;
            case 3:
                // deletarUsuario();
                break;
            case 4:
                break;
            default:
                iniciarSistemaInterno();
                break;
        }
    }

    private void listarUsuarioAtual(){
        profileScreen.limparConsole();
        profileScreen.mostrarUsuario();

        System.out.println("\nDigite zero(0) para voltar...");
        setarEscolhaNumerica();
        if (escolhaDeUsuario == 0) {
            profileScreen.limparConsole();
            iniciarSistemaInterno();
        } else {
            listarUsuarioAtual();
        }
    }

    private void editarUsuario(){

    }

    private void deletarUsuario(){

    }

    //* Funções de registro
    private void registerEmailInput() {
        String newUserEmail = emailInput();
        if(retornarPaginaLogin(newUserEmail))
            return;

        User usuarioEncontrado = userService.verificacaoDeEmail(newUserEmail);
        if(usuarioEncontrado != null) {
            loginText.jaExiste();
            registerEmailInput();
            scanner.close();
            return;
        }

        boolean IsEmailCorrect = userService.confirmarSeEmailEstaCorreto(newUserEmail);
        if(!IsEmailCorrect) {
            loginText.mensagemDeErroGenerico("O email deve conter @");
            registerEmailInput();
            scanner.close();
            return;
        }
        User newUser = new User(0, newUserEmail, "");
        registerSenhaInput(newUser);
    }

    private void registerSenhaInput(User newUser) {
        loginText.senhaPrecisa();
        String newPassword = senhaInput();

        boolean IsPasswordCorrect = userService.confirmarSeSenhaEstaCorreto(newPassword);
        if(!IsPasswordCorrect) {
            loginText.mensagemDeErroGenerico("Senha invalida");
            registerSenhaInput(newUser);
            scanner.close();
            return;
        }

        newUser.setPassword(newPassword);

        userService.completarRegistro(newUser);
        comecarLoginOuRegister();
    }


    private boolean retornarPaginaLogin(String newInput) {
        if(newInput.compareTo("0") == 0) {
            loginText.limparConsole();
            comecarLoginOuRegister();
            scanner.close();
            return true;
        }
        return false;
    }

    protected void setarEscolhaNumerica() {
        try {
            this.escolhaDeUsuario = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            loginText.mensagemDeErroGenerico("Escolha uma opção valida");
        }
    }

    protected String emailInput() {
        loginText.pedirEmail();
        return scanner.nextLine();
    }
    protected String senhaInput() {
        loginText.pedirSenha();
        return scanner.nextLine();
    }
}
