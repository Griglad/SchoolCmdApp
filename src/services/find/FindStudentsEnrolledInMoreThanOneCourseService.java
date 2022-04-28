package services.find;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.Student;
import utilities.Platform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindStudentsEnrolledInMoreThanOneCourseService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();

    public List<Student> findEnrolledStudentsInMoreThanOneCourse(Platform platform) {

        List<Student> studentsInAllCourses = schoolDao.getStudentsInCourses(platform)
                .stream()
                .flatMap(e -> e.getStudents().stream())
                .collect(Collectors.toList());

        return studentsInAllCourses.stream()
                .filter((student) -> Collections.frequency(studentsInAllCourses, student) > 1)
                .collect(Collectors.toSet()).stream().toList();

    }
}
