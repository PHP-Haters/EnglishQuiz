package dao;
import java.util.HashMap;

import model.User;
import model.Question;
import model.Level;

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
        for (User user : users.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
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


    public static HashMap<Integer, Level> level = new HashMap<Integer, Level>();
    
    //Funções relacionadas aos níveis da trilha
    public static void levels() {
        Level levelUm = new Level(0, "Primeiro nível", Level.Types.INICIANTE);
        Level levelDois = new Level(1, "Segundo nível", Level.Types.INTERMEDIARIO); 
        Level levelTres = new Level(2, "Terceiro nível", Level.Types.AVANCADO);

        level.put(0, levelUm);
        level.put(1, levelDois);
        level.put(2, levelTres);
    }


    public static HashMap<Integer, Question> question = new HashMap<Integer, Question>();

    //Funções relacionadas as questões do level
    public static void questoes(){
        Question questionUm_1 = new Question(0, "I ____ Brazilian and i live in Foz do iguaçu", level.get(0));
        Question questionDois_1 = new Question(1, "I ____ Brazilian and i live in Foz do iguaçu", level.get(0));
        Question questionTres_1 = new Question(2, "I ____ Brazilian and i live in Foz do iguaçu", level.get(0));
        Question questionQuatro_1 = new Question(3, "I ____ Brazilian and i live in Foz do iguaçu", level.get(0));
        Question questionCinco_1 = new Question(4, "I ____ Brazilian and i live in Foz do iguaçu", level.get(0));

        question.put(0, questionUm_1);
        question.put(1, questionDois_1);
        question.put(2, questionTres_1);
        question.put(3, questionQuatro_1);
        question.put(4, questionCinco_1);

        Question questionUm_2 = new Question(5, "I ____ Brazilian and i live in Foz do iguaçu", level.get(1));
        Question questionDois_2 = new Question(6, "I ____ Brazilian and i live in Foz do iguaçu", level.get(1));
        Question questionTres_2 = new Question(7, "I ____ Brazilian and i live in Foz do iguaçu", level.get(1));
        Question questionQuatro_2 = new Question(8, "I ____ Brazilian and i live in Foz do iguaçu", level.get(1));
        Question questionCinco_2 = new Question(9, "I ____ Brazilian and i live in Foz do iguaçu", level.get(1));

        question.put(5, questionUm_2);
        question.put(6, questionDois_2);
        question.put(7, questionTres_2);
        question.put(8, questionQuatro_2);
        question.put(9, questionCinco_2);

        Question questionUm_3 = new Question(10, "I ____ Brazilian and i live in Foz do iguaçu", level.get(2));
        Question questionDois_3 = new Question(11, "I ____ Brazilian and i live in Foz do iguaçu", level.get(2));
        Question questionTres_3 = new Question(12, "I ____ Brazilian and i live in Foz do iguaçu", level.get(2));
        Question questionQuatro_3 = new Question(13, "I ____ Brazilian and i live in Foz do iguaçu", level.get(2));
        Question questionCinco_3 = new Question(14, "I ____ Brazilian and i live in Foz do iguaçu", level.get(2));

        question.put(10, questionUm_3);
        question.put(11, questionDois_3);
        question.put(12, questionTres_3);
        question.put(13, questionQuatro_3);
        question.put(14, questionCinco_3);
    }
    
}
