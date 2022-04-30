package views;

import services.menu.UsersMainMenuService;
//Singleton class
public class MainView {

    private static MainView instance;


    public static MainView getInstance() {
        if (instance == null) {
            instance = new MainView();
        }
        instance.showMainView();
        return instance;
    }

    public void showMainView() {
        UsersMainMenuService.getInstance().showMenu();
    }
}
