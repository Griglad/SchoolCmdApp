package services.display;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.Student;
import utilities.Platform;

import java.util.List;

public class DisplayStudentsService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();


    public void display(Platform platform) {
        List<Student> students = schoolDao.getStudents(platform);
        if (!students.isEmpty()) {
            System.out.println("--------STUDENTS-------");
            schoolDao.getStudents(platform).forEach(System.out::println);
        } else {
            System.out.println("--------NO STUDENTS FOUND-------");
        }

    }


}
