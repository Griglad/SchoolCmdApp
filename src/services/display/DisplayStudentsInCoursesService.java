package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.StudentsInCourse;
import utilities.Platform;

import java.util.List;

public class DisplayStudentsInCoursesService {


    private final SchoolDao schoolDao = new SchoolDaoImpl();


    public void display(Platform platform) {
        List<StudentsInCourse> studentsInCourses = schoolDao.getStudentsInCourses(platform);
        if (!studentsInCourses.isEmpty()) {
            System.out.println("--------STUDENTS_PER_COURSE-------");
            studentsInCourses.forEach(System.out::println);
        } else {
            System.out.println("--------NO STUDENTS_PER_COURSE FOUND-------");
        }

    }
}
