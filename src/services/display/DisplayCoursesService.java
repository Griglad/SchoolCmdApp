package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.Course;
import utilities.Platform;

import java.util.List;


public class DisplayCoursesService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();


    public void display(Platform platform) {
        List<Course> courses = schoolDao.getCourses(platform);
        if (courses.isEmpty()) {
            System.out.println("--------COURSES-------");
            courses.forEach(System.out::println);
        } else {
            System.out.println("--------NO COURSES FOUND-------");
        }
    }

}
