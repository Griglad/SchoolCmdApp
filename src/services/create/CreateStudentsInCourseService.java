package services.create;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.Course;
import model.Student;
import model.StudentsInCourse;
import utilities.Input;
import utilities.InputValidator;
import utilities.Platform;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CreateStudentsInCourseService {

    private final Scanner input = Input.getInstance();
    private final SchoolDao schoolDao = new SchoolDaoImpl();

    public StudentsInCourse create(Course course) {
        StudentsInCourse studentsInCourse = new StudentsInCourse();
        studentsInCourse.setCourse(course);
        String afm;
        String firstName;
        String lastName;
        LocalDate dateOfBirth;
        String tuitionFees;
        Student student;
        boolean flag = false;
        while (!flag) {
            System.out.println("----ADDING STUDENT'S TO THE COURSE " + course.getTitle());
            System.out.println("AFM:");
            afm = String.valueOf(InputValidator.provideAfmWithNineDigits(input));
            if (schoolDao.findStudentInCourseByAfm(studentsInCourse, afm) != null) {
                System.out.println("THIS STUDENT ALREADY EXISTS,PLEASE CREATE ANOTHER STUDENT.");
            } else {
                System.out.println("FIRST NAME:");
                firstName = InputValidator.provideOnlyString(input);
                System.out.println("LAST NAME:");
                lastName = InputValidator.provideOnlyString(input);
                System.out.println("BIRTH DATE:");
                dateOfBirth = InputValidator.validateBirthDate();
                System.out.println(("GIVE THE STUDENT'S TUITION FEES:"));
                double fees = InputValidator.provideNumToDouble(input);
                tuitionFees = String.valueOf(fees);
                student = new Student(afm, firstName, lastName, dateOfBirth, tuitionFees);
                List<StudentsInCourse> studentsInCourseList = schoolDao.getStudentsInCourses(Platform.DATABASE);
                List<Student> studentList = schoolDao.getStudents(Platform.DATABASE);
                if (schoolDao.findStudentByAfm(afm) == null) {
                    //Adding the student in the general students list
                    studentList.add(student);
                }
                //Adding the trainer in the Students of this specific course
                studentsInCourse.addStudent(student);
                /*
                    Adding a studentInCourse object in the StudentInCourse list.
                    This stores a list of students for each course in a list of type
                    StudentInCourse. This list is used to display StudentsPerCourse
                */
                if (!studentsInCourseList.contains(studentsInCourse)) {
                    studentsInCourseList.add(studentsInCourse);
                }
                System.out.println("DO YOU WANT TO ADD ANOTHER STUDENT TO THE COURSE " + course.getTitle() + "?");
                System.out.println(("1 - YES"));
                System.out.println(("2 - NO"));
                boolean more = InputValidator.yesOrNoMenu();
                if (!more) {
                    flag = true;
                }
            }
        }
        return studentsInCourse;
    }
}
