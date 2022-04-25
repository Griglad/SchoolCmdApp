package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import utilities.Platform;

public class DisplayAssignmentsInStudentsService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();

    public void display(Platform platform) {
        if (!schoolDao.getAssignmentsInStudents(platform).isEmpty()) {
            System.out.println("--------ASSIGNMENTS_PER_STUDENT-------");
            schoolDao.getAssignmentsInStudents(platform).forEach(System.out::println);
        } else {
            System.out.println("--------NO ASSIGNMENTS_PER_STUDENT FOUND-------");
        }

    }
}

