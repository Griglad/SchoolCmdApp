package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.TrainersInCourse;
import utilities.Platform;

import java.util.List;

public class DisplayTrainersInCoursesService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();

    public void display(Platform platform) {
        List<TrainersInCourse> trainersInCourses = schoolDao.getTrainersInCourses(platform);
        if (!trainersInCourses.isEmpty()) {
            System.out.println("--------TRAINERS_PER_COURSE-------");
            trainersInCourses.forEach(System.out::println);
        } else {
            System.out.println("--------NO TRAINERS_PER_COURSE FOUND-------");
        }

    }

}

