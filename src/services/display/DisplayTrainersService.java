package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import utilities.Platform;

public class DisplayTrainersService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();


    public void display(Platform platform) {
        if (!schoolDao.getTrainers(platform).isEmpty()) {
            System.out.println("--------TRAINERS-------");
            schoolDao.getTrainers(platform).forEach(System.out::println);
        } else {
            System.out.println("--------NO TRAINERS FOUND-------");
        }

    }
}
