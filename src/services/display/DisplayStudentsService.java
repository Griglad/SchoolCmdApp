package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import utilities.Platform;

public class DisplayStudentsService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();


    public void display(Platform platform) {
        if (!schoolDao.getStudents(platform).isEmpty()) {
            System.out.println("--------STUDENTS-------");
            schoolDao.getStudents(platform).forEach(System.out::println);
        } else {
            System.out.println("--------NO STUDENTS FOUND-------");
        }

    }


}
