package services.create;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.Assignment;
import model.AssignmentsInCourse;
import model.Course;
import utilities.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class CreateAssignmentsInCourseService {

    private final Scanner input = Input.getInstance();
    private final SchoolDao schoolDao = new SchoolDaoImpl();


    public AssignmentsInCourse create(Course course) {
        AssignmentsInCourse assignmentsInCourse = new AssignmentsInCourse();
        assignmentsInCourse.setCourse(course);
        String assignmentTitle;
        String description;
        LocalDate subDateTime;
        String oralMark;
        String totalMark;
        Assignment assignment;
        boolean flag = false;
        while (!flag) {
            System.out.println("----ADDING ASSIGNMENTS TO THE COURSE " + course.getTitle());
            //ASSIGNMENT CREATION
            System.out.println("ASSIGNMENT'S TITLE:");
            assignmentTitle = InputValidator.provideOnlyString(input);
            if (schoolDao.findAssignmentInCourseByTitle(assignmentsInCourse, assignmentTitle) != null) {
                System.out.println("THIS ASSIGNMENT ALREADY EXISTS,PLEASE CREATE ANOTHER ASSIGNMENT.");
            } else {
                System.out.println("DESCRIPTION:");
                description = InputValidator.provideOnlyString(input);
                System.out.println("SUBMISSION DATE:");
                subDateTime = InputValidator.provideSubDate(course.getStart_date(), course.getEnd_date());
                System.out.println("ORAL-MARK:");
                double doubleOralMark = InputValidator.provideNumToDouble(input);
                oralMark = String.valueOf(doubleOralMark);
                System.out.println("TOTAL-MARK:");
                double doubleTotalMark = InputValidator.provideNumToDouble(input);
                totalMark = String.valueOf(doubleTotalMark);
                assignment = new Assignment(assignmentTitle, description, subDateTime, oralMark, totalMark);
                List<AssignmentsInCourse> assignmentsInCourses = schoolDao.getAssignmentsInCourses(Platform.DATABASE);
                List<Assignment> assignmentList = schoolDao.getAssignments(Platform.DATABASE);

                if (schoolDao.findAssignmentByTitle(assignmentTitle) == null) {
                    //Adding the course in the general list of assignments
                    assignmentList.add(assignment);
                }

                //Adding an assignment in the assignments of this specific course
                assignmentsInCourse.addAssignment(assignment);
                /*
                Adding an assignmentInCourse object in the AssignmentsInCourse list.
                This stores a list of assignments for each course in a list of type
                assignmentInCourse.This list is used to display AssignmentsPerCourse
                 */
                if (!assignmentsInCourses.contains(assignmentsInCourse)) {
                    assignmentsInCourses.add(assignmentsInCourse);
                }
                System.out.println("DO YOU WANT TO CREATE ANOTHER ASSIGNMENT FOR THIS COURSE?");
                System.out.println(("1 - YES"));
                System.out.println(("2 - NO"));
                boolean moreAssignments = InputValidator.yesOrNoMenu();
                if (!moreAssignments && assignmentsInCourse.getAssignments().size() == 7) {
                    flag = true;
                } else {
                    StringBuilder builder = new StringBuilder();
                    builder.append("YOU HAVE TO ADD 7 ASSIGNMENTS FOR THE COURSE:");
                    builder.append(course.getTitle());
                    if (assignmentsInCourse.getAssignments().size() > 1) {
                        builder.append(" YOU NOW HAVE THE ASSIGNMENTS:");
                    } else {
                        builder.append(" YOU NOW HAVE THE ASSIGNMENT:");
                    }
                    builder.append(assignmentsInCourse.getAssignments().stream()
                            .map(as -> as.getTitle().toUpperCase()).collect(Collectors.joining(",")));
                    System.out.println(builder.toString());
                }
            }
        }
        return assignmentsInCourse;
    }
}


