package model;

public class Session{
    private static Session instance;
    private User loggedUser;

    public static Session getInstance(){
        if (instance == null) {
            instance = new Session();
        }

        return instance;
    }

    public void setLoggedUser(User loggedUser){
        this.loggedUser = loggedUser;
    }

    public User getLoggedUser(){
        return this.loggedUser;
    }
}
