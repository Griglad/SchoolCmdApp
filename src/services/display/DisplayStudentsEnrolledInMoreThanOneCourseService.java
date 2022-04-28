package services.display;

import services.find.FindStudentsEnrolledInMoreThanOneCourseService;
import utilities.Platform;


public class DisplayStudentsEnrolledInMoreThanOneCourseService {

    private final FindStudentsEnrolledInMoreThanOneCourseService findStudentsEnrolledInMoreThanOneCourseService
            = new FindStudentsEnrolledInMoreThanOneCourseService();

    public void display(Platform platform) {
        if (!findStudentsEnrolledInMoreThanOneCourseService.findEnrolledStudentsInMoreThanOneCourse(platform).isEmpty()) {
            System.out.println("--------STUDENTS ENROLLED IN MORE THAN ONE COURSE-------");
            findStudentsEnrolledInMoreThanOneCourseService.getStudentsInMoreThanOneCourse()
                    .forEach(student ->
                            System.out.println(student.getFirstName().toUpperCase() + " " + student.getLastName().toUpperCase()));
        } else {
            System.out.println("--------NO STUDENTS ENROLLED IN MORE THAN ONE COURSE FOUND-------");
        }

    }
}
