package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AssignmentsInStudent {

    private Student student;
    private List<Assignment> assignments = new ArrayList<>();
    private static int count;

    public AssignmentsInStudent() {

    }

    public AssignmentsInStudent(Student student, List<Assignment> assignments) {
        this.student = student;
        this.assignments = assignments;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignmentsInStudent that = (AssignmentsInStudent) o;
        return student.equals(that.student) && assignments.equals(that.assignments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, assignments);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(++count + "-");
        sb.append("THE STUDENT IS:")
                .append(student.getFirstName().toUpperCase() + " " + student.getLastName().toUpperCase());
        if (assignments.size() > 1) {
            sb.append(",THE ASSIGNMENTS ARE:");
        } else {
            sb.append(",THE ASSIGNMENT IS:");
        }
        sb.append(assignments.stream()
                .map(assignment -> assignment.getTitle().toUpperCase())
                .collect(Collectors.joining(",")));
        return sb.toString();
    }

}
