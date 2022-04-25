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
    private List<Student> studentsInMoreThanOneCourse = new ArrayList<>();

    public List<Student> findEnrolledStudentsInMoreThanOneCourse(Platform platform) {

        List<Student> students = schoolDao.getStudentsInCourses(platform)
                .stream()
                .flatMap(e -> e.getStudents()
                        .stream())
                .collect(Collectors.toList());

        studentsInMoreThanOneCourse = students.stream()
                .filter((student) -> Collections.frequency(students, student) > 1)
                .collect(Collectors.toSet()).stream().toList();

        return studentsInMoreThanOneCourse;

    }

    public List<Student> getStundentsInMoreThanOneCourse() {
        return studentsInMoreThanOneCourse;
    }
}
