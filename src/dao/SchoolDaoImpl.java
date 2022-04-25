package dao;

import database.Database;
import model.*;

import utilities.Platform;
import utilities.SyntheticData;

import java.util.List;
import java.util.Optional;


public class SchoolDaoImpl implements SchoolDao {


    private static final SyntheticData syntheticDta = SyntheticData.getInstance();
    private static final Database dataBase = Database.getInstance();



    /*
        Platform: SyntheticData or Database

        Based on the platform decide which data to return.
        The prepared data or the data from the database
     */

    @Override
    public List<Trainer> getTrainers(Platform platform) {
        List<Trainer> trainers;
        if (platform.getType().equals("SyntheticData")) {
            trainers = syntheticDta.getTrainers();
        } else {
            trainers = dataBase.getTrainers();
        }
        return trainers;
    }

    @Override
    public List<Student> getStudents(Platform platform) {
        List<Student> students;
        if (platform.getType().equals("SyntheticData")) {
            students = syntheticDta.getStudents();
        } else {
            students = dataBase.getStudents();
        }
        return students;
    }

    @Override
    public List<Course> getCourses(Platform platform) {
        List<Course> courses;
        if (platform.getType().equals("SyntheticData")) {
            courses = syntheticDta.getCourses();
        } else {
            courses = dataBase.getCourses();
        }
        return courses;
    }

    @Override
    public List<Assignment> getAssignments(Platform platform) {
        List<Assignment> assignments;
        if (platform.getType().equals("SyntheticData")) {
            assignments = syntheticDta.getAssignments();
        } else {
            assignments = dataBase.getAssignments();
        }
        return assignments;
    }

    @Override
    public List<StudentsInCourse> getStudentsInCourses(Platform platform) {
        List<StudentsInCourse> studentsInCourses;
        if (platform.getType().equals("SyntheticData")) {
            studentsInCourses = syntheticDta.getStudentsInCourses();
        } else {
            studentsInCourses = dataBase.getStudentsInCourses();
        }
        return studentsInCourses;
    }

    @Override
    public List<TrainersInCourse> getTrainersInCourses(Platform platform) {
        List<TrainersInCourse> trainersInCourses;
        if (platform.getType().equals("SyntheticData")) {
            trainersInCourses = syntheticDta.getTrainersInCourses();
        } else {
            trainersInCourses = dataBase.getTrainersInCourses();
        }
        return trainersInCourses;
    }

    @Override
    public List<AssignmentsInCourse> getAssignmentsInCourses(Platform platform) {
        List<AssignmentsInCourse> assignmentsInCourses;
        if (platform.getType().equals("SyntheticData")) {
            assignmentsInCourses = syntheticDta.getAssignmentsInCourses();
        } else {
            assignmentsInCourses = dataBase.getAssignmentsInCourses();
        }
        return assignmentsInCourses;
    }

    @Override
    public List<AssignmentsInStudent> getAssignmentsInStudents(Platform platform) {
        List<AssignmentsInStudent> assignmentsInStudents;
        if (platform.getType().equals("SyntheticData")) {
            assignmentsInStudents = syntheticDta.getAssignmentsInStudents();
        } else {
            assignmentsInStudents = dataBase.getAssignmentsInStudents();
        }
        return assignmentsInStudents;
    }


    @Override
    public Course findCourseByTitle(String title) {
        Course foundCourse = null;
        Optional<Course> optionalCourse = dataBase.getCourses()
                .stream()
                .filter(c -> c.getTitle().equalsIgnoreCase(title)).findFirst();

        if (optionalCourse.isPresent()) {
            foundCourse = optionalCourse.get();
        }
        return foundCourse;
    }

    @Override
    public Assignment findAssignmentByTitle(String title) {
        Assignment foundAssignment = null;
        Optional<Assignment> optionalAssignment = dataBase.getAssignments()
                .stream()
                .filter(a -> a.getTitle().equalsIgnoreCase(title)).findFirst();
        if (optionalAssignment.isPresent()) {
            foundAssignment = optionalAssignment.get();
        }
        return foundAssignment;
    }

    @Override
    public Trainer findTrainerByAfm(String afm) {
        Trainer foundTrainer = null;
        Optional<Trainer> optionalTrainer = dataBase.getTrainers()
                .stream()
                .filter(t -> t.getAfm().equals(afm)).findFirst();
        if (optionalTrainer.isPresent()) {
            foundTrainer = optionalTrainer.get();
        }
        return foundTrainer;
    }

    @Override
    public Student findStudentByAfm(String afm) {
        Student foundStudent = null;
        Optional<Student> optionalStudent = dataBase.getStudents()
                .stream()
                .filter(s -> s.getAfm().equals(afm)).findFirst();
        if (optionalStudent.isPresent()) {
            foundStudent = optionalStudent.get();
        }
        return foundStudent;
    }

    @Override
    public Assignment findAssignmentInCourseByTitle(AssignmentsInCourse assignmentsInCourse, String title) {
        Assignment foundAssignment = null;
        Optional<Assignment> optionalAssignment = assignmentsInCourse.getAssignments()
                .stream().filter(assignment -> assignment.getTitle().equalsIgnoreCase(title))
                .findFirst();
        if (optionalAssignment.isPresent()) {
            foundAssignment = optionalAssignment.get();
        }
        return foundAssignment;
    }


    @Override
    public Trainer findTrainerInCourseByAfm(TrainersInCourse trainersInCourse, String afm) {
        Trainer foundTrainer = null;
        Optional<Trainer> optionalTrainer = trainersInCourse.getTrainers()
                .stream().filter(trainer -> trainer.getAfm().equals(afm))
                .findFirst();
        if (optionalTrainer.isPresent()) {
            foundTrainer = optionalTrainer.get();
        }
        return foundTrainer;
    }

    @Override
    public Student findStudentInCourseByAfm(StudentsInCourse studentsInCourse, String afm) {
        Student foundStudent = null;
        Optional<Student> optionalStudent = studentsInCourse.getStudents()
                .stream().filter(student -> student.getAfm().equals(afm))
                .findFirst();
        if (optionalStudent.isPresent()) {
            foundStudent = optionalStudent.get();
        }
        return foundStudent;
    }

    @Override
    public Assignment findAssignmentInStudentByTitle(AssignmentsInStudent assignmentsInStudent, String title) {
        Assignment foundAssingment = null;
        Optional<Assignment> optionalAssignment = assignmentsInStudent.getAssignments()
                .stream().filter(assignment -> assignment.getTitle().equalsIgnoreCase(title))
                .findFirst();
        if (optionalAssignment.isPresent()) {
            foundAssingment = optionalAssignment.get();
        }
        return foundAssingment;
    }

}
