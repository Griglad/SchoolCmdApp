package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.AssignmentsInStudent;
import utilities.Platform;

import java.util.List;

public class DisplayAssignmentsInStudentsService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();

    public void display(Platform platform) {
        List<AssignmentsInStudent> assignmentsInStudents = schoolDao.getAssignmentsInStudents(platform);
        if (!assignmentsInStudents.isEmpty()) {
            System.out.println("--------ASSIGNMENTS_PER_STUDENT-------");
            assignmentsInStudents.forEach(System.out::println);
        } else {
            System.out.println("--------NO ASSIGNMENTS_PER_STUDENT FOUND-------");
        }

    }
}

