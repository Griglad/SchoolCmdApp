package services.create;

import model.AssignmentsInCourse;
import model.Course;
import model.StudentsInCourse;

public class CreateAllDataService {

    private final CreateCourseService createCourseService = new CreateCourseService();
    private final CreateAssignmentsInCourseService createAssignmentsInCourseService = new CreateAssignmentsInCourseService();
    private final CreateTrainersInCourseService createTrainersInCourseService = new CreateTrainersInCourseService();
    private final CreateStudentsInCourseService createStudentsInCourseService = new CreateStudentsInCourseService();
    private final CreateAssignmentsInStudentService createAssignmentsInStudentService = new CreateAssignmentsInStudentService();
    private boolean isAllDataCreated = false;

    public void create() {
        Course createdCourse = createCourseService.create();
        //Check if the user tries to create a specific course twice
        if (createdCourse != null) {
            //createTrainersInCourseService.create(createdCourse);
            //AssignmentsInCourse assignmentInCourse = createAssignmentsInCourseService.create(createdCourse);
           // StudentsInCourse studentsInCourse = createStudentsInCourseService.create(createdCourse);
           // createAssignmentsInStudentService.create(studentsInCourse, assignmentInCourse);
            isAllDataCreated = true;
        }
    }

    public boolean isAllDataCreated() {
        return isAllDataCreated;
    }


}
