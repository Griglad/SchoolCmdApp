package services.create;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.Course;
import utilities.*;

import java.time.LocalDate;

import java.util.*;
import java.util.stream.Collectors;

public class CreateCourseService {

    private final Scanner input = Input.getInstance();
    private final SchoolDao schoolDao = new SchoolDaoImpl();

    public Course create() {
        String title;
        List<Stream> streams;
        List<Type> types;
        LocalDate startDate;
        LocalDate endDate;
        Course course = null;
        boolean flag = false;
        while (!flag) {
            System.out.println("COURSE TITLE:");
            title = InputValidator.provideStringsAndMinOneDigit(input);
            if (schoolDao.findCourseByTitle(title) != null) {
                System.out.println("THIS COURSE ALREADY EXISTS,PLEASE CREATE ANOTHER COURSE.");
                flag = true;
            } else {
                System.out.println("AVAILABLE STREAMS: " + Stream.getStreamNames());
                streams = InputValidator.provideStreams(input);
                types = streams
                        .stream()
                        .flatMap(e -> e.getTypes().stream()).collect(Collectors.toList());
                //Taking the distinct types
                Set<Type> distinctTypes = new HashSet<>(types);
                //making the set back to list
                List<Type> distinctTypesList = new ArrayList<>(distinctTypes);
                System.out.println("START DATE");
                startDate = InputValidator.provideStartDate();
                System.out.println(("END DATE:"));
                endDate = InputValidator.provideEndDate(startDate);
                course = new Course(title, streams, distinctTypesList, startDate, endDate);
                schoolDao.getCourses(Platform.DATABASE).add(course);
                flag = true;
            }
        }
        return course;
    }
}

