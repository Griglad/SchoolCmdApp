package services.create;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import model.*;
import utilities.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CreateTrainersInCourseService {

    private final Scanner input = Input.getInstance();
    private final SchoolDao schoolDao = new SchoolDaoImpl();

    public void create(Course course) {
        TrainersInCourse trainersInCourse = new TrainersInCourse();
        trainersInCourse.setCourse(course);
        String afm;
        String firstName;
        String lastName;
        List<Subject> subjects;
        Trainer trainer = null;
        boolean flag = false;
        while (!flag) {
            System.out.println("----ADDING TRAINER'S TO THE COURSE " + course.getTitle());
            System.out.println("AFM:");
            afm = String.valueOf(InputValidator.provideAfmWithNineDigits(input));
            if (schoolDao.findTrainerInCourseByAfm(trainersInCourse, afm) != null) {
                System.out.println("THIS TRAINER ALREADY EXISTS,PLEASE CREATE ANOTHER TRAINER.");
            } else {
                System.out.println("FIRST NAME:");
                firstName = InputValidator.provideOnlyString(input);
                System.out.println("LAST NAME:");
                lastName = InputValidator.provideOnlyString(input);
                System.out.println("AVAILABLE SUBJECTS: " + Subject.getSubjectNames());
                subjects = InputValidator.provideSubjects(input);
                List<Subject> distinctSubjects = subjects.stream().distinct().collect(Collectors.toList());
                trainer = new Trainer(afm, firstName, lastName, distinctSubjects);
                List<TrainersInCourse> trainersInCourseList = schoolDao.getTrainersInCourses(Platform.DATABASE);
                List<Trainer> trainerList = schoolDao.getTrainers(Platform.DATABASE);
                if (schoolDao.findTrainerByAfm(afm) == null) {
                    //Adding the trainer in the general trainers list
                    trainerList.add(trainer);
                }
                //Adding the trainer in the Trainers of this specific course
                trainersInCourse.addTrainer(trainer);
                /*
                   Adding a trainerInCourse object in the TrainerInCourse list.
                   This stores a list of trainers for each course in a list of type
                   TrainerInCourse. This list is used to display TrainersPerCourse
                */
                if (!trainersInCourseList.contains(trainersInCourse)) {
                    trainersInCourseList.add(trainersInCourse);
                }
                System.out.println("DO YOU WANT TO CREATE ANOTHER TRAINER?");
                System.out.println(("1 - YES"));
                System.out.println(("2 - NO"));
                boolean more = InputValidator.yesOrNoMenu();
                if (!more) {
                    flag = true;
                }
            }
        }
    }
}
