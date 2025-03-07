package controller;

import java.util.Scanner;

import model.User;
import service.UserService;
import view.LoginText;

public class UserController implements Controlller{

    LoginText loginText;
    UserService userService;
    Scanner scanner;
    int escolhaDeUsuario;

    protected UserController() {
        loginText = new LoginText();
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
            loginText.mensagemDeErroGenerico();
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
            //todo Session.setUserInSession(usuarioEncontrado);
            loginText.limparConsole();
        }
        else {
            loginText.mensagemDeErroGenerico();
            inputDaSenhaLogin(usuarioEncontrado);
        }
        scanner.close();
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
            loginText.mensagemDeErroGenerico();
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
            loginText.mensagemDeErroGenerico();
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
            loginText.mensagemDeErroGenerico();
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
