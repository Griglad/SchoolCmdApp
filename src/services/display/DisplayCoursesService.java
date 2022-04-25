package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import utilities.Platform;


public class DisplayCoursesService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();


    public void display(Platform platform) {
        if (!schoolDao.getCourses(platform).isEmpty()) {
            System.out.println("--------COURSES-------");
            schoolDao.getCourses(platform).forEach(System.out::println);
        } else {
            System.out.println("--------NO COURSES FOUND-------");
        }

    }

}
