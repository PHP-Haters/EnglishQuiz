import controller.UserController;
import dao.PseudoDataBase;
import model.User;

public class Main {
    public static void main(String[] args) {
        User admin = new User(0, "admin@gmail.com", "admin");
        PseudoDataBase.addUser(admin);

        UserController userController = new UserController();
        userController.abrirView();
    }
}