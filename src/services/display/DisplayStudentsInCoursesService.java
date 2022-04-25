package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import utilities.Platform;

public class DisplayStudentsInCoursesService {


    private final SchoolDao schoolDao = new SchoolDaoImpl();


    public void display(Platform platform) {
        if (!schoolDao.getStudentsInCourses(platform).isEmpty()) {
            System.out.println("--------STUDENTS_PER_COURSE-------");
            schoolDao.getStudentsInCourses(platform).forEach(System.out::println);
        } else {
            System.out.println("--------NO STUDENTS_PER_COURSE FOUND-------");
        }

    }
}
