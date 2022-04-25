package dao;

import model.*;
import utilities.Platform;


import java.util.List;

public interface SchoolDao {

    List<Trainer> getTrainers(Platform platform);

    List<Student> getStudents(Platform platform);

    List<Course> getCourses(Platform platform);

    List<Assignment> getAssignments(Platform platform);

    List<StudentsInCourse> getStudentsInCourses(Platform platform);

    List<TrainersInCourse> getTrainersInCourses(Platform platform);

    List<AssignmentsInCourse> getAssignmentsInCourses(Platform platform);

    List<AssignmentsInStudent> getAssignmentsInStudents(Platform platform);

    Course findCourseByTitle(String title);

    Assignment findAssignmentByTitle(String title);

    Trainer findTrainerByAfm(String afm);

    Student findStudentByAfm(String afm);

    Assignment findAssignmentInCourseByTitle(AssignmentsInCourse assignmentsInCourse, String title);

    Assignment findAssignmentInStudentByTitle(AssignmentsInStudent assignmentsInStudent, String title);

    Trainer findTrainerInCourseByAfm(TrainersInCourse trainersInCourse, String afm);

    Student findStudentInCourseByAfm(StudentsInCourse studentsInCourse, String afm);

}
