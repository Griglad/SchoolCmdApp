package services.menu;

import services.display.*;
import utilities.Input;
import utilities.InputValidator;
import utilities.Platform;
import utilities.Style;

import java.util.Scanner;

public class SyntheticMenuService {

    private static SyntheticMenuService instance;
    private final Scanner input = Input.getInstance();
    private final DisplayStudentsService displayStudentsService = new DisplayStudentsService();
    private final DisplayTrainersService displayTrainersService = new DisplayTrainersService();
    private final DisplayCoursesService displayCoursesService = new DisplayCoursesService();
    private final DisplayAssignmentsService displayAssignmentsService = new DisplayAssignmentsService();
    private final DisplayStudentsInCoursesService displayStudentsInCoursesService = new DisplayStudentsInCoursesService();
    private final DisplayTrainersInCoursesService displayTrainersInCoursesService = new DisplayTrainersInCoursesService();
    private final DisplayAssignmentsInCoursesService displayAssignmentsInCoursesService = new DisplayAssignmentsInCoursesService();
    private final DisplayAssignmentsInStudentsService displayAssignmentsInStudentsService = new DisplayAssignmentsInStudentsService();
    private final DisplayStudentsEnrolledInMoreThanOneCourseService displayStudentsEnrolledInMoreThanOneCourseService = new DisplayStudentsEnrolledInMoreThanOneCourseService();
    private final DisplayStudentsOnTheSameCalendarWeekService displayStudentsOnTheSameCalendarWeekService = new DisplayStudentsOnTheSameCalendarWeekService();


    public static SyntheticMenuService getInstance() {
        if (instance == null) {
            instance = new SyntheticMenuService();
        }
        return instance;
    }

    public void showSyntheticMenu() {

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
            System.out.println(("9") + " -  STUDENTS WHO BELONG TO MORE THAN ONE COURSE");
            System.out.println(("10") + " - STUDENTS WHO NEED TO SUBMIT ONE OR MORE ASSIGNMENTS ON THE USER'S INPUT DATE");
            System.out.println(("11") + " - BACK");
            System.out.println(("12") + " - EXIT");

            result = InputValidator.provideNumToInteger(input);

            switch (result) {
                case 1 -> {
                    displayStudentsService
                            .display(Platform.SYNTHETIC);
                    Style.blank();
                }
                case 2 -> {
                    displayTrainersService
                            .display(Platform.SYNTHETIC);
                    Style.blank();
                }
                case 3 -> {
                    displayCoursesService
                            .display(Platform.SYNTHETIC);
                    Style.blank();
                }
                case 4 -> {
                    displayAssignmentsService
                            .display(Platform.SYNTHETIC);
                    Style.blank();
                }
                case 5 -> {
                    displayStudentsInCoursesService
                            .display(Platform.SYNTHETIC);
                    Style.blank();
                }
                case 6 -> {
                    displayTrainersInCoursesService
                            .display(Platform.SYNTHETIC);
                    Style.blank();
                }
                case 7 -> {
                    displayAssignmentsInStudentsService
                            .display(Platform.SYNTHETIC);
                    Style.blank();
                }
                case 8 -> {
                    displayAssignmentsInCoursesService
                            .display(Platform.SYNTHETIC);
                    Style.blank();
                }
                case 9 -> {
                    displayStudentsEnrolledInMoreThanOneCourseService
                            .display(Platform.SYNTHETIC);
                    Style.blank();
                }
                case 10 -> {
                    displayStudentsOnTheSameCalendarWeekService
                            .display(Platform.SYNTHETIC);
                    Style.blank();
                }
                case 11 -> {
                    UsersMainMenuService.getInstance().showMenu();
                    Style.blank();
                }

                case 12 -> System.exit(0);
            }
        }
    }
}
