package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import utilities.Platform;

public class DisplayAssignmentsService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();


    public void display(Platform platform) {
        if (!schoolDao.getAssignments(platform).isEmpty()) {
            System.out.println("--------ASSIGNMENTS-------");
            schoolDao.getAssignments(platform).forEach(System.out::println);
        } else {
            System.out.println("--------NO ASSIGNMENTS FOUND-------");
        }

    }
}
