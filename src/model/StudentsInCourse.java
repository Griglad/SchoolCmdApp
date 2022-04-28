package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentsInCourse {

    private Course course;
    private List<Student> students = new ArrayList<>();
    private static int count;

    public StudentsInCourse() {

    }

    public StudentsInCourse(Course course, List<Student> students) {
        this.course = course;
        this.students = students;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsInCourse that = (StudentsInCourse) o;
        return Objects.equals(course, that.course) && Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, students);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(++count + "-");
        sb.append("THE COURSE IS:").append(course.getTitle());
        if (students.size() > 1) {
            sb.append(",THE STUDENTS ARE:");
        } else {
            sb.append(",THE STUDENT IS:");
        }
        sb.append(students.stream()
                .map(student -> student.getFirstName().toUpperCase() + " " + student.getLastName().toUpperCase())
                .collect(Collectors.joining(",")));
        return sb.toString();
    }
}
