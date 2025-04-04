package model;

public class User {
    private int id;
    private String email;
    private String password;
    private Type type;

    enum Type {
        ADMIN,
        USER,
        TEACHER
    }

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        type = Type.USER;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
