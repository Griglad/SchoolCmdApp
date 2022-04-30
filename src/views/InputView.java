package views;

import services.menu.InputMenuService;

//Singleton class
public class InputView {

    private static InputView inputView;


    private InputView() {

    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }


    public void showInputView() {
        InputMenuService.getInstance().showInputMenu();
    }
}

