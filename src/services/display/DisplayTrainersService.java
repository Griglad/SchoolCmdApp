package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.Trainer;
import utilities.Platform;

import java.util.List;

public class DisplayTrainersService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();


    public void display(Platform platform) {
        List<Trainer> trainers = schoolDao.getTrainers(platform);
        if (!trainers.isEmpty()) {
            System.out.println("--------TRAINERS-------");
            trainers.forEach(System.out::println);
        } else {
            System.out.println("--------NO TRAINERS FOUND-------");
        }

    }
}
