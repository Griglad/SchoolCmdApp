package database;

import model.*;

import java.util.ArrayList;
import java.util.List;

//Singleton Class
//The Supposed database where all the data will be stored
public class Database {

    private static Database instance;
    private final List<Course> courses = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Trainer> trainers = new ArrayList<>();
    private final List<Assignment> assignments = new ArrayList<>();
    private final List<StudentsInCourse> studentsInCourses = new ArrayList<>();
    private final List<TrainersInCourse> trainersInCourses = new ArrayList<>();
    private final List<AssignmentsInCourse> assignmentsInCourses = new ArrayList<>();
    private final List<AssignmentsInStudent> assignmentsInStudents = new ArrayList<>();

    private Database(){

    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public List<StudentsInCourse> getStudentsInCourses() {
        return studentsInCourses;
    }

    public List<TrainersInCourse> getTrainersInCourses() {
        return trainersInCourses;
    }

    public List<AssignmentsInCourse> getAssignmentsInCourses() {
        return assignmentsInCourses;
    }

    public List<AssignmentsInStudent> getAssignmentsInStudents() {
        return assignmentsInStudents;
    }
}
