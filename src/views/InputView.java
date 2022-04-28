package views;

import services.display.*;
import services.menu.UsersMenuService;
import utilities.Input;
import utilities.InputValidator;
import utilities.Platform;
import utilities.Style;

import java.util.Scanner;

//Singleton class
public class InputView {

    private static InputView inputView;
    private final Scanner input = Input.getInstance();
    private final DisplayStudentsService displayStudentsService = new DisplayStudentsService();
    private final DisplayCoursesService displayCoursesService = new DisplayCoursesService();
    private final DisplayTrainersService displayTrainersService = new DisplayTrainersService();
    private final DisplayAssignmentsService displayAssignmentsService = new DisplayAssignmentsService();
    private final DisplayStudentsInCoursesService displayStudentsInCoursesService = new DisplayStudentsInCoursesService();
    private final DisplayAssignmentsInCoursesService displayAssignmentsInCoursesService = new DisplayAssignmentsInCoursesService();
    private final DisplayTrainersInCoursesService displayTrainersInCoursesService = new DisplayTrainersInCoursesService();
    private final DisplayAssignmentsInStudentsService displayAssignmentsInStudentsService = new DisplayAssignmentsInStudentsService();
    private final DisplayStudentsEnrolledInMoreThanOneCourseService displayStudentsEnrolledInMoreThanOneCourseService = new DisplayStudentsEnrolledInMoreThanOneCourseService();
    private final DisplayStudentsOnTheSameCalendarWeekService displayStudentsOnTheSameCalendarWeekService = new DisplayStudentsOnTheSameCalendarWeekService();


    private InputView() {

    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }


    public void showMenu() {

        while (true) {
            int result;
            System.out.println("PLEASE SELECT ONE OF THE FOLLOWING");

            System.out.println(("1") + " -  STUDENTS");
            System.out.println(("2") + " -  TRAINERS");
            System.out.println(("3") + " -  COURSES");
            System.out.println(("4") + " -  ASSIGNMENTS");
            System.out.println(("5") + " -  STUDENTS_PER_COURSE");
            System.out.println(("6") + " -  TRAINERS_PER_COURSE");
            System.out.println(("7") + " -  ASSIGNMENTS_PER_STUDENT");
            System.out.println(("8") + " -  ASSIGNMENTS_PER_COURSE");
            System.out.println(("9") + " -  STUDENTS ENROLLED IN MORE THAN ONE COURSE");
            System.out.println(("10") + " - STUDENTS WHO NEED TO SUBMIT ONE OR MORE ASSIGNMENTS ON THE USER'S INPUT DATE");
            System.out.println(("11") + " - BACK");
            System.out.println(("12") + " - EXIT");


            result = InputValidator.provideNumToInteger(input);

            switch (result) {
                case 1 -> {
                    displayStudentsService.display(Platform.DATABASE);
                    Style.blank();
                }
                case 2 -> {
                    displayTrainersService.display(Platform.DATABASE);
                    Style.blank();
                }
                case 3 -> {
                    displayCoursesService.display(Platform.DATABASE);
                    Style.blank();
                }
                case 4 -> {
                    displayAssignmentsService.display(Platform.DATABASE);
                    Style.blank();
                }
                case 5 -> {
                    displayStudentsInCoursesService.display(Platform.DATABASE);
                    Style.blank();
                }
                case 6 -> {
                    displayTrainersInCoursesService.display(Platform.DATABASE);
                    Style.blank();
                }
                case 7 -> {
                    displayAssignmentsInStudentsService.display(Platform.DATABASE);
                    Style.blank();
                }
                case 8 -> {
                    displayAssignmentsInCoursesService.display(Platform.DATABASE);
                    Style.blank();
                }
                case 9 -> {
                    displayStudentsEnrolledInMoreThanOneCourseService.display(Platform.DATABASE);
                    Style.blank();
                }

                case 10 -> {
                    displayStudentsOnTheSameCalendarWeekService.display(Platform.DATABASE);
                    Style.blank();
                }
                case 11 -> {
                    UsersMenuService.getInstance();
                    Style.blank();
                }
                case 12 -> {
                    System.exit(0);
                }
            }
        }
    }
}
