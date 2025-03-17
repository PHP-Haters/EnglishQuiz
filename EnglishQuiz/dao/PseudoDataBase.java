package dao;
import java.util.HashMap;

import model.User;
import model.Question;

public class PseudoDataBase {


    public static HashMap<Integer, User> users = new HashMap<Integer, User>();

    //*Funções relacionadas a tratar com os usuários
    public static void addUser(User newUser) {
        users.put(newUser.getId(), newUser);
    }
    public static void deleteUserById(int id) {
        users.remove(id);
    }
    public static void editUser(User newUser) {
        users.replace(newUser.getId(), newUser);
    }

    public static User getUserById(int idUser) {
        return users.get(idUser);
    }

    public static User doesUserExist(String email) {
        for(int i = 0; i <= users.size(); i++) {
            if(users.get(i) != null)
                if(users.get(i).getEmail().compareTo(email) == 0)
                    return users.get(i);
        }
        return null;
    }

    //* Permite pegar o maior ID de usuário
    public static int getLastId() {

        int biggestId = 0;
        for (Integer key : users.keySet()) {
            if (biggestId == 0 || key > biggestId) {
                biggestId = key;
            }
        }
        return biggestId;
    }

    public static HashMap<String,Question> question = new HashMap<String, Question>();

    //*Funções relacionadas as questões do level
    public static void questoes(Question newQuestion){
        question.put("I ____ Brazilian and i live in Foz do iguaçu", newQuestion);
    }
}
