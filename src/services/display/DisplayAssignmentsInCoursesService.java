package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import utilities.Platform;

public class DisplayAssignmentsInCoursesService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();

    public void display(Platform platform) {
        if (!schoolDao.getAssignmentsInCourses(platform).isEmpty()) {
            System.out.println("--------ASSIGNMENTS_PER_COURSE-------");
            schoolDao.getAssignmentsInCourses(platform).forEach(System.out::println);
        } else {
            System.out.println("--------N0 ASSIGNMENTS_PER_COURSE FOUND-------");
        }
    }

}

