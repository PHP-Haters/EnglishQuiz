package model;

public class Question {
    private int id;
    private String text;
    private Level level;

    public Question(int id, String text,Level level) {
        this.id = id;
        this.text = text;
        this.level = level;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public Level getLevel() {
        return level;
    }


    public void setLevel(Level level) {
        this.level = level;
    }
}