package views;

import services.menu.SyntheticMenuService;

//Singleton class
public class SyntheticView {

    private static SyntheticView syntheticView;


    public static SyntheticView getInstance() {
        if (syntheticView == null) {
            syntheticView = new SyntheticView();
        }
        return syntheticView;
    }


    public void showSyntheticView() {
        SyntheticMenuService.getInstance().showSyntheticMenu();
    }
}
