import controller.MainController;
import controller.UserController;
import dao.PseudoDataBase;
import model.User;
import server.Session;

public class Main {
    public static void main(String[] args) {
        User admin = new User(0, "admin@gmail.com", "admin");
        PseudoDataBase.addUser(admin);

        UserController userController = new UserController();
        userController.abrirView();

        if(Session.getInstance().getLoggedUser() != null) {
            MainController mainController = new MainController();
            mainController.abrirView();
        }
        
    }
}