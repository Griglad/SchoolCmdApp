package services.display;

import services.find.FindStudentsOnTheSameCalendarWeekService;
import utilities.Platform;


public class DisplayStudentsOnTheSameCalendarWeekService {

    private final FindStudentsOnTheSameCalendarWeekService findStudentsOnTheSameCalendarWeekService
            = new FindStudentsOnTheSameCalendarWeekService();


    public void display(Platform platform) {
        final StringBuilder builder = new StringBuilder();
        if (!findStudentsOnTheSameCalendarWeekService.findStudentsOnTheSameCalendarWeek(platform).isEmpty()) {
            findStudentsOnTheSameCalendarWeekService.getStudentsOnTheSameCalendarWeek()
                    .forEach(e -> builder.append(e.getFirstName()
                            .toUpperCase()).append(" ").append(e.getLastName().toUpperCase()).append("\n"));

            System.out.println("--------STUDENTS WHO NEED TO SUBMIT ONE OR MORE ASSIGNMENTS ON THE SAME CALENDAR WEEK AS THE GIVEN DATE--------");
            System.out.println(builder);

        } else {
            System.out.println("--------NO STUDENTS WHO NEED TO SUBMIT ONE OR MORE ASSIGNMENTS ON THE SAME CALENDAR WEEK AS THE GIVEN DATE FOUND--------");
        }

    }

}
