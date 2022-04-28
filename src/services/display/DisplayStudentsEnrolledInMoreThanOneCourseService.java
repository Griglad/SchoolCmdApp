package services.display;

import model.Student;
import services.find.FindStudentsEnrolledInMoreThanOneCourseService;
import utilities.Platform;

import java.util.List;


public class DisplayStudentsEnrolledInMoreThanOneCourseService {

    private final FindStudentsEnrolledInMoreThanOneCourseService findStudentsEnrolledInMoreThanOneCourseService
            = new FindStudentsEnrolledInMoreThanOneCourseService();

    public void display(Platform platform) {
        List<Student> foundStudents = findStudentsEnrolledInMoreThanOneCourseService.findEnrolledStudentsInMoreThanOneCourse(platform);
        if (!foundStudents.isEmpty()) {
            System.out.println("--------STUDENTS ENROLLED IN MORE THAN ONE COURSE-------");
            foundStudents.forEach(student ->System.out.println(student.getFirstName().toUpperCase() + " " + student.getLastName().toUpperCase()));

        } else {
            System.out.println("--------NO STUDENTS ENROLLED IN MORE THAN ONE COURSE FOUND-------");
        }

    }
}
