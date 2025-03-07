package dao;
import java.util.HashMap;

import model.User;

public class PseudoDataBase {
 

    public static HashMap<Integer, User> users = new HashMap<Integer, User>();

    public static void addUser(User newUser) {
        users.put(newUser.getId(), newUser);
    }

    public static void deleteUser(User userToDelete) {
        users.remove(userToDelete.getId());
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

    public static int getLastId() {

        int biggestId = 0;
        for (Integer key : users.keySet()) { 
            if (biggestId == 0 || key > biggestId) { 
                biggestId = key; 
            } 
        } 
        return biggestId;
    }
}
