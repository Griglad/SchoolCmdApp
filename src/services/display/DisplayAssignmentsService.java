package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.Assignment;
import utilities.Platform;

import java.util.List;

public class DisplayAssignmentsService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();


    public void display(Platform platform) {
        List<Assignment> assignments = schoolDao.getAssignments(platform);
        if (!assignments.isEmpty()) {
            System.out.println("--------ASSIGNMENTS-------");
            assignments.forEach(System.out::println);
        } else {
            System.out.println("--------NO ASSIGNMENTS FOUND-------");
        }

    }
}
