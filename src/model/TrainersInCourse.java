package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainersInCourse {

    private Course course;
    private List<Trainer> trainers = new ArrayList<>();
    private static volatile int count;

    public TrainersInCourse() {

    }

    public TrainersInCourse(Course course, List<Trainer> trainers) {
        this.course = course;
        this.trainers = trainers;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }


    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(++count + "-");
        long numberOfTrainers = trainers.size();
        sb.append("THE COURSE IS:").append(course.getTitle());
        if (numberOfTrainers > 1) {
            sb.append(",THE TRAINERS ARE:");
        } else {
            sb.append(",THE TRAINER IS:");
        }
        sb.append(trainers
                .stream()
                .map(trainer -> trainer.getFirstName().toUpperCase() + " " + trainer.getLastName().toUpperCase())
                .collect(Collectors.joining(",")));

        return sb.toString();
    }
}
