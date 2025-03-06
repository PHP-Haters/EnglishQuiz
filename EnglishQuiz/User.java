package EnglishQuiz;

public class User {
    private int id;
    private String email;
    private String password;

    User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    void setId(int id) {
        this.id = id;
    }
    int getId() {
        return id;
    }

    void setEmail(String email) {
        this.email = email;
    }
    String getEmail() {
        return email;
    }

    void setPassword(String password) {
        this.password = password;
    }
    String getPassword() {
        return password;
    }
    

}
