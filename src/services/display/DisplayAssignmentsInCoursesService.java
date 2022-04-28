package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.AssignmentsInCourse;
import utilities.Platform;

import java.util.List;

public class DisplayAssignmentsInCoursesService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();

    public void display(Platform platform) {
        List<AssignmentsInCourse> assignmentsInCourses = schoolDao.getAssignmentsInCourses(platform);
        if (!assignmentsInCourses.isEmpty()) {
            System.out.println("--------ASSIGNMENTS_PER_COURSE-------");
            assignmentsInCourses.forEach(System.out::println);
        } else {
            System.out.println("--------N0 ASSIGNMENTS_PER_COURSE FOUND-------");
        }
    }

}

