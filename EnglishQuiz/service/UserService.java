package service;

import dao.PseudoDataBase;
import model.User;

public class UserService {
    

    public User verificacaoDeEmail(String email) {
        User doesUserExist = PseudoDataBase.doesUserExist(email);
        if(doesUserExist == null && email.contains("@") == false)
            return null;

        return doesUserExist;
    }

    public boolean verificacaoDeSenha(User userToCompare, String password) {
        if(userToCompare.getPassword().compareTo(password) == 0)
            return true;

        return false;
    }

    public boolean confirmarSeEmailEstaCorreto(String newEmail) {
        if(newEmail.contains("@"))
            return true;
        else
            return false;
    }
    public boolean confirmarSeSenhaEstaCorreto(String newPassword) {
        if(newPassword.length() >= 8)
            return true;
        else
            return false;
    }

    public void completarRegistro(User newUser) {

        newUser.setId(PseudoDataBase.getLastId()+1);

        PseudoDataBase.addUser(newUser);
    }
}
