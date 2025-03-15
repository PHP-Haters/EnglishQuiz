package model;

public class Level {
    private int id;
    private String nomeLevel;
    private Types types;

    enum Types {
        INICIANTE,
        INTERMEDIARIO,
        AVANÇADO
    }


}
