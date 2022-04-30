package services.find;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.Assignment;
import model.AssignmentsInStudent;
import model.Student;
import utilities.Input;
import utilities.InputValidator;
import utilities.Platform;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;

/*
    Students who need to submit one or more assignments on the same calendar week as the given date
 */
public class FindStudentsOnTheSameCalendarWeekService {

    private final SchoolDao schoolDao = new SchoolDaoImpl();
    private final Scanner input = Input.getInstance();

    public List<Student> findStudentsOnTheSameCalendarWeek(Platform platform) {

        System.out.println("PLEASE PROVIDE A DATE:");

        LocalDate localDate = InputValidator.provideADate(input);

        Map<Student, List<Assignment>> filteredMap =
                schoolDao
                        .getAssignmentsInStudents(platform)
                        .stream()
                        .collect(Collectors
                                .toMap(AssignmentsInStudent::getStudent, AssignmentsInStudent::getAssignments))
                        .entrySet()
                        .stream()
                        .filter(studentAssignments -> studentAssignments.getValue()
                                .stream()
                                .anyMatch(assignment -> isInSameWeek(localDate, assignment.getSubDateTime())))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return filteredMap.keySet().stream().toList();
    }

    public boolean isInSameWeek(LocalDate date, LocalDate assignmentDate) {
        Locale locale = Locale.getDefault();
        boolean isInSameWeek = false;
        int givenWeekOfYear = date.get(WeekFields.of(locale).weekOfYear());
        int givenWeekOfAssignment = assignmentDate.get(WeekFields.of(locale).weekOfYear());
        if (date.getYear() == assignmentDate.getYear()) {
            isInSameWeek = givenWeekOfYear == givenWeekOfAssignment;
        }
        return isInSameWeek;
    }


}
