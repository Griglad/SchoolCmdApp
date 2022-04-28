package services.create;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.*;
import utilities.Input;
import utilities.InputValidator;
import utilities.Platform;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CreateAssignmentsInStudentService {

    private final Scanner input = Input.getInstance();
    private final SchoolDao schoolDao = new SchoolDaoImpl();

    public void create(StudentsInCourse studentsInCourse, AssignmentsInCourse assignmentsInCourse) {
        AssignmentsInStudent assignmentsInStudent;
        String courseTitle = studentsInCourse.getCourse().getTitle();
        String afm;
        String title;
        Student foundStudent;
        Assignment foundAssignment;
        boolean flag1 = false;
        boolean flag2 = false;
        while (!flag1) {
            System.out.println("----ADDING ASSIGNMENTS TO STUDENTS FOR THE COURSE " + courseTitle);
            System.out.println("STUDENT AFM");
            afm = String.valueOf(InputValidator.provideNumToInteger(input));
            if (schoolDao.findStudentInCourseByAfm(studentsInCourse, afm) != null) {
                foundStudent = schoolDao.findStudentByAfm(afm);
                assignmentsInStudent = new AssignmentsInStudent();
                assignmentsInStudent.setStudent(foundStudent);
                while (!flag2) {
                    System.out.println("ASSIGNMENT TITLE");
                    title = String.valueOf(InputValidator.provideOnlyString(input));
                    if (schoolDao.findAssignmentInCourseByTitle(assignmentsInCourse, title) != null) {

                        //Checks if his assignment has already been assigned to this student
                        if (schoolDao.findAssignmentInStudentByTitle(assignmentsInStudent, title) == null) {
                            foundAssignment = schoolDao.findAssignmentByTitle(title);

                            List<AssignmentsInStudent> assignmentsInStudents = schoolDao.getAssignmentsInStudents(Platform.DATABASE);
                            //Adding an assignment in the assignments of this specific student
                            assignmentsInStudent.addAssignment(foundAssignment);

                          /*
                            Adding an assignmentInStudent object in the AssignmentsInStudent list.
                            This stores a list of assignments for each student in a list of type
                            assignmentInStudent.This list is used to display AssignmentsPerStudent
                           */
                            if (!assignmentsInStudents.contains(assignmentsInStudent)) {
                                assignmentsInStudents.add(assignmentsInStudent);
                            }
                        } else {
                            System.out.println("THIS STUDENT WITH AFM " + afm + " HAS ALREADY BEEN ASSIGNED THE ASSIGNMENT WITH TITLE " + title);
                        }

                    } else {
                        System.out.println("THIS ASSIGNMENT DOES NOT EXIST PLEASE INPUT A CORRECT ASSIGNMENT");
                    }
                    System.out.println("DO YOU WANT TO ADD ANOTHER ASSIGNMENT FOR THE STUDENT WITH AFM " + afm);
                    System.out.println(("1 - YES"));
                    System.out.println(("2 - NO"));
                    boolean more = InputValidator.yesOrNoMenu();
                    if (!more && assignmentsInStudent.getAssignments().size() == 7) {
                        flag2 = true;
                    } else {
                        StringBuilder builder = new StringBuilder();
                        builder.append("YOU HAVE TO ADD 7 ASSIGNMENTS FOR THIS STUDENT WITH AFM:");
                        builder.append(assignmentsInStudent.getStudent().getAfm());
                        if (assignmentsInStudent.getAssignments().size() > 1) {
                            builder.append(" YOU NOW HAVE THE ASSIGNMENTS:");
                        } else if (assignmentsInStudent.getAssignments().size() == 1) {
                            builder.append(" YOU NOW HAVE THE ASSIGNMENT:");
                        } else {
                            builder.append(" YOU DON'T HAVE ANY ASSIGNMENTS");
                        }
                        builder.append(assignmentsInStudent.getAssignments().stream()
                                .map(as -> as.getTitle().toUpperCase()).collect(Collectors.joining(",")));
                        System.out.println(builder.toString());
                    }
                }
            } else {
                System.out.println("THIS STUDENT WITH AFM " + afm + " DOES NOT EXIST PLEASE INPUT A CORRECT STUDENT'S AFM");
            }

            System.out.println("DO YOU WANT TO ADD AN ASSIGNMENT FOR ANOTHER STUDENT?");
            System.out.println(("1 - YES"));
            System.out.println(("2 - NO"));
            boolean more = InputValidator.yesOrNoMenu();
            if (!more) {
                flag1 = true;
            } else {
                flag2 = false;
            }
        }

    }

}
