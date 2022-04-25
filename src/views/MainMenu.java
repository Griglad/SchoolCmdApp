package views;

import services.create.CreateAllDataService;
import utilities.Input;
import utilities.InputValidator;
import utilities.Style;

import java.util.Scanner;

//Singleton Class
public class MainMenu {

    private static MainMenu instance;
    private static final InputView inputView = InputView.getInstance();
    private static final SyntheticView syntheticView = SyntheticView.getInstance();
    private static final Scanner input = Input.getInstance();
    private final CreateAllDataService createAllDataService = new CreateAllDataService();


    private MainMenu() {

    }


    public static MainMenu getInstance() {
        if (instance == null) {
            synchronized (MainMenu.class) {
                if (instance == null) {
                    instance = new MainMenu();
                }
            }
        }
        return instance;
    }


    public void showMenu() {

        System.out.println(("WELCOME TO REMEDIAL TEACHING APPLICATION"));
        System.out.println(("THIS APPLICATION SIMULATES A PRIVATE SCHOOL WHICH OFFERS REMEDIAL TEACHING SERVICES\n"));
        userChoice();

    }

    private void userChoice() {

        int correctInput;

        System.out.println("WOULD YOU LIKE TO USE SOME PREPARED DATA OR");
        System.out.println("WOULD YOU LIKE TO RUN THE PROGRAM WITH YOUR OWN DATA?\n");


        while (true) {
            System.out.println("PLEASE WRITE THE RIGHT NUMBER");
            System.out.println(("1") + " - DISPLAY DATA IN TESTING MODE");
            System.out.println(("2") + " - CONTINUE TO CREATE YOUR DATA");
            System.out.println(("3") + " - DISPLAY YOUR ADDED DATA");
            System.out.println(("4") + " - EXIT");
            correctInput = InputValidator.provideNumToInteger(input);

            switch (correctInput) {
                case 1 -> syntheticView.showMenu();
                case 2 -> createAllDataService.create();
                case 3 -> {
                    if (createAllDataService.isAllDataCreated()) {
                        inputView.showMenu();
                        Style.blank();
                    } else {
                        System.out.println("YOU DIDN'T CREATE ANY DATA PLEASE PRESS 2 TO CRATE DATA");
                        Style.blank();
                    }
                }
                case 4 -> System.exit(0);
                default -> inputView.showMenu();
            }
        }
    }
}
