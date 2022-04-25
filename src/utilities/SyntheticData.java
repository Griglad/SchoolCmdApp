package utilities;

import model.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


//Singleton class
public class SyntheticData {

    private static SyntheticData instance;
    private final List<Course> courses;
    private final List<Student> students;
    private final List<Trainer> trainers;
    private final List<Assignment> assignments;
    private final List<StudentsInCourse> studentsInCourses;
    private final List<TrainersInCourse> trainersInCourses;
    private final List<AssignmentsInCourse> assignmentsInCourses;
    private final List<AssignmentsInStudent> assignmentsInStudents;


    public static SyntheticData getInstance() {
        if (instance == null) {
            instance = new SyntheticData();
        }
        return instance;
    }

    private SyntheticData() {
        //Streams
        List<Stream> streams = Stream.getStreams().stream()
                .peek(e -> e.setTypes(Arrays.asList(Type.PARTTIME, Type.FULLTIME))).collect(Collectors.toList());
        //Types
        List<Type> types = Type.getTypes().stream().toList();

        //Subjects
        List<Subject> subjects = Subject.getSubjects().stream().toList();

        //Courses
        Course cb8 = new Course("CB8", streams.subList(0, 2), types, LocalDate.of(2022, 2, 28), LocalDate.of(2022, 9, 25));
        Course cb9 = new Course("CB9", streams.subList(1, 2), types, LocalDate.of(2022, 1, 30), LocalDate.of(2022, 8, 25));
        Course cb10 = new Course("CB10", streams.subList(3, 4), types, LocalDate.of(2022, 4, 5), LocalDate.of(2022, 7, 10));
        Course cb11 = new Course("CB11", streams.subList(2, 4), types, LocalDate.of(2022, 4, 15), LocalDate.of(2022, 7, 14));
        courses = Arrays.asList(cb8, cb9, cb10, cb11);

        //Students
        Student antKaramixos = new Student("123456789", "Antonis", "Karamixos", LocalDate.of(1990, 3, 25), "2250");
        Student kostasApidopoulos = new Student("090975312", "Kwstas", "Apidopoulos", LocalDate.of(1991, 4, 15), "2250");
        Student grigorisLadas = new Student("965367888", "Grigoris", "Ladas", LocalDate.of(1992, 7, 5), "2250");
        Student makisKaratasou = new Student("763987312", "Makis", "Karatasou", LocalDate.of(1980, 5, 25), "2250");
        Student dimitrisAravopoulos = new Student("323654313", "Dimitris", "Aravopoulos", LocalDate.of(1993, 3, 15), "2250");
        Student kwnstantinaManiati = new Student("987654321", "Kwnstantina", "Maniati", LocalDate.of(1992, 3, 10), "2250");
        students = Arrays.asList(antKaramixos, kostasApidopoulos, grigorisLadas, makisKaratasou, dimitrisAravopoulos, kwnstantinaManiati);


        //Trainers
        Trainer giorgosIraklidis = new Trainer("125633145", "Giorgos", "Iraklidis", subjects.subList(0, 2));
        Trainer giorgosPasparakis = new Trainer("115632145", "Giorgos", "Pasparakis", subjects.subList(1, 2));
        Trainer antonisThodos = new Trainer("125332145", "Antonis", "Thodos", subjects.subList(1, 3));
        Trainer rafGalanopoulou = new Trainer("125632149", "Rafaila", "Galanopoulou", subjects.subList(2, 4));
        Trainer giannisMantoudis = new Trainer("125632147", "Giannis", "Mantoudis", subjects.subList(3, 4));

        trainers = Arrays.asList(giorgosIraklidis, giorgosPasparakis, antonisThodos, rafGalanopoulou);

        //Assignments
        Assignment htmlAssignment = new Assignment("Website implementation", "Create a website using html and css", LocalDate.of(2022, 4, 11), "20", "80");
        Assignment cmdAssignment = new Assignment("Cmd App", "Create a command line app based on your stream's language", LocalDate.of(2022, 5, 10), "20", "70");
        Assignment sqlAssignment = new Assignment("Sql", "Create a database and produce some Queries", LocalDate.of(2022, 6, 6), "20", "60");
        Assignment reactAssignment = new Assignment("React App", "Create a website using react library", LocalDate.of(2022, 6, 9), "20", "70");
        Assignment angularAssignment = new Assignment("Angular App", "Create a website using angular library", LocalDate.of(2022, 6, 10), "20", "70");
        Assignment individualProject = new Assignment("API implementation", "Create an API with your Streams's back-end framework", LocalDate.of(2022, 7, 20), "20", "70");
        Assignment teamProject = new Assignment("Web application", "Create a web application", LocalDate.of(2022, 9, 15), "15", "65");

        assignments = Arrays.asList(htmlAssignment,
                cmdAssignment, sqlAssignment,
                reactAssignment, angularAssignment,
                individualProject, teamProject);


        //Students Per Course
        StudentsInCourse studentInCb8 = new StudentsInCourse();
        studentInCb8.setCourse(cb8);
        studentInCb8.addStudent(antKaramixos);
        studentInCb8.addStudent(kostasApidopoulos);
        studentInCb8.addStudent(grigorisLadas);

        StudentsInCourse studentInCb9 = new StudentsInCourse();
        studentInCb9.setCourse(cb9);
        studentInCb9.addStudent(antKaramixos);
        studentInCb9.addStudent(kostasApidopoulos);

        StudentsInCourse studentInCb10 = new StudentsInCourse();
        studentInCb10.setCourse(cb10);
        studentInCb10.addStudent(kostasApidopoulos);
        studentInCb10.addStudent(kwnstantinaManiati);

        StudentsInCourse studentInCb11 = new StudentsInCourse();
        studentInCb11.setCourse(cb11);
        studentInCb11.addStudent(antKaramixos);
        studentInCb11.addStudent(kostasApidopoulos);
        studentInCb11.addStudent(grigorisLadas);
        studentInCb11.addStudent(makisKaratasou);
        studentInCb11.addStudent(dimitrisAravopoulos);
        studentInCb11.addStudent(kwnstantinaManiati);

        studentsInCourses = Arrays.asList(studentInCb8, studentInCb9, studentInCb10, studentInCb11);


        //Trainers Per Course
        TrainersInCourse trainerInJava = new TrainersInCourse();
        trainerInJava.setCourse(cb8);
        trainerInJava.addTrainer(giorgosIraklidis);
        trainerInJava.addTrainer(giorgosPasparakis);

        TrainersInCourse trainerInCsharp = new TrainersInCourse();
        trainerInCsharp.setCourse(cb9);
        trainerInCsharp.addTrainer(antonisThodos);
        trainerInCsharp.addTrainer(giorgosPasparakis);

        TrainersInCourse trainerInPython = new TrainersInCourse();
        trainerInPython.setCourse(cb10);
        trainerInPython.addTrainer(giorgosIraklidis);

        TrainersInCourse trainerInJavaScript = new TrainersInCourse();
        trainerInJavaScript.setCourse(cb11);
        trainerInJavaScript.addTrainer(giannisMantoudis);


        trainersInCourses = Arrays.asList(trainerInJava, trainerInCsharp, trainerInPython, trainerInJavaScript);


        //AssignmentsPerCourse
        AssignmentsInCourse assignmentInCB8 = new AssignmentsInCourse();
        assignmentInCB8.setCourse(cb8);
        assignmentInCB8.addAssignment(htmlAssignment);
        assignmentInCB8.addAssignment(cmdAssignment);
        assignmentInCB8.addAssignment(reactAssignment);
        assignmentInCB8.addAssignment(individualProject);
        assignmentInCB8.addAssignment(teamProject);

        AssignmentsInCourse assignmentInCB9 = new AssignmentsInCourse();
        assignmentInCB9.setCourse(cb9);
        assignmentInCB9.addAssignment(htmlAssignment);
        assignmentInCB9.addAssignment(cmdAssignment);
        assignmentInCB9.addAssignment(sqlAssignment);
        assignmentInCB9.addAssignment(angularAssignment);
        assignmentInCB9.addAssignment(individualProject);
        assignmentInCB9.addAssignment(teamProject);

        AssignmentsInCourse assignmentInCB10 = new AssignmentsInCourse();
        assignmentInCB10.setCourse(cb10);
        assignmentInCB10.addAssignment(htmlAssignment);
        assignmentInCB10.addAssignment(cmdAssignment);
        assignmentInCB10.addAssignment(sqlAssignment);
        assignmentInCB10.addAssignment(angularAssignment);
        assignmentInCB10.addAssignment(individualProject);
        assignmentInCB10.addAssignment(teamProject);

        AssignmentsInCourse assignmentInCB11 = new AssignmentsInCourse();
        assignmentInCB11.setCourse(cb11);
        assignmentInCB11.addAssignment(htmlAssignment);
        assignmentInCB11.addAssignment(cmdAssignment);
        assignmentInCB11.addAssignment(sqlAssignment);
        assignmentInCB11.addAssignment(reactAssignment);
        assignmentInCB11.addAssignment(individualProject);
        assignmentInCB11.addAssignment(teamProject);


        assignmentsInCourses = Arrays.asList(assignmentInCB8, assignmentInCB9, assignmentInCB10, assignmentInCB11);


        //AssignmentsPerStudent
        AssignmentsInStudent assignmentToAntKaramixos = new AssignmentsInStudent();
        assignmentToAntKaramixos.setStudent(antKaramixos);
        assignmentToAntKaramixos.addAssignment(htmlAssignment);
        assignmentToAntKaramixos.addAssignment(cmdAssignment);
        assignmentToAntKaramixos.addAssignment(sqlAssignment);
        assignmentToAntKaramixos.addAssignment(reactAssignment);
        assignmentToAntKaramixos.addAssignment(individualProject);
        assignmentToAntKaramixos.addAssignment(teamProject);

        AssignmentsInStudent assignmentToKostasApidopoulos = new AssignmentsInStudent();
        assignmentToKostasApidopoulos.setStudent(kostasApidopoulos);
        assignmentToKostasApidopoulos.addAssignment(htmlAssignment);
        assignmentToKostasApidopoulos.addAssignment(cmdAssignment);
        assignmentToKostasApidopoulos.addAssignment(sqlAssignment);
        assignmentToKostasApidopoulos.addAssignment(angularAssignment);
        assignmentToKostasApidopoulos.addAssignment(individualProject);
        assignmentToKostasApidopoulos.addAssignment(teamProject);


        AssignmentsInStudent assignmentToGrigorisLadas = new AssignmentsInStudent();
        assignmentToGrigorisLadas.setStudent(grigorisLadas);
        assignmentToGrigorisLadas.addAssignment(htmlAssignment);
        assignmentToGrigorisLadas.addAssignment(cmdAssignment);
        assignmentToGrigorisLadas.addAssignment(sqlAssignment);
        assignmentToGrigorisLadas.addAssignment(reactAssignment);
        assignmentToGrigorisLadas.addAssignment(individualProject);
        assignmentToGrigorisLadas.addAssignment(teamProject);


        AssignmentsInStudent assignmentToKwnstantinaManiati = new AssignmentsInStudent();
        assignmentToKwnstantinaManiati.setStudent(kwnstantinaManiati);
        assignmentToKwnstantinaManiati.addAssignment(htmlAssignment);
        assignmentToKwnstantinaManiati.addAssignment(cmdAssignment);
        assignmentToKwnstantinaManiati.addAssignment(sqlAssignment);
        assignmentToKwnstantinaManiati.addAssignment(angularAssignment);
        assignmentToKwnstantinaManiati.addAssignment(individualProject);
        assignmentToKwnstantinaManiati.addAssignment(teamProject);


        AssignmentsInStudent assignmentToMakisKaratasou = new AssignmentsInStudent();
        assignmentToMakisKaratasou.setStudent(makisKaratasou);
        assignmentToMakisKaratasou.addAssignment(htmlAssignment);
        assignmentToMakisKaratasou.addAssignment(cmdAssignment);
        assignmentToMakisKaratasou.addAssignment(sqlAssignment);
        assignmentToMakisKaratasou.addAssignment(reactAssignment);
        assignmentToMakisKaratasou.addAssignment(individualProject);
        assignmentToMakisKaratasou.addAssignment(teamProject);


        AssignmentsInStudent assignmentTodimitrisAravopoulos = new AssignmentsInStudent();
        assignmentTodimitrisAravopoulos.setStudent(dimitrisAravopoulos);
        assignmentTodimitrisAravopoulos.addAssignment(htmlAssignment);
        assignmentTodimitrisAravopoulos.addAssignment(cmdAssignment);
        assignmentTodimitrisAravopoulos.addAssignment(sqlAssignment);
        assignmentTodimitrisAravopoulos.addAssignment(angularAssignment);
        assignmentTodimitrisAravopoulos.addAssignment(individualProject);
        assignmentTodimitrisAravopoulos.addAssignment(teamProject);




        assignmentsInStudents = Arrays
                .asList(assignmentToAntKaramixos
                        , assignmentToKostasApidopoulos
                        , assignmentToGrigorisLadas
                        , assignmentToKwnstantinaManiati
                        , assignmentToMakisKaratasou, assignmentTodimitrisAravopoulos);

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
