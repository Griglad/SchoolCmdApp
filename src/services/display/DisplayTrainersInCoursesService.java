package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import utilities.Platform;

public class DisplayTrainersInCoursesService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();

    public void display(Platform platform) {
        if (!schoolDao.getTrainersInCourses(platform).isEmpty()) {
            System.out.println("--------TRAINERS_PER_COURSE-------");
            schoolDao.getTrainersInCourses(platform).forEach(System.out::println);
        } else {
            System.out.println("--------NO TRAINERS_PER_COURSE FOUND-------");
        }

    }

}

