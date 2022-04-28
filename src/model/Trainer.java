package model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Trainer {
    private String afm;
    private String firstName;
    private String lastName;
    private List<Subject> subjects;
    private static int count;

    public Trainer(String afm, String firstName, String lastName, List<Subject> subjects) {
        this.afm = afm;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return afm.equals(trainer.afm) && firstName.equals(trainer.firstName) && lastName.equals(trainer.lastName) && subjects.equals(trainer.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(afm);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(++count + "-");
        sb.append("THE AFM IS:").append(afm);
        sb.append(",THE FIRST NAME IS:").append(firstName.toUpperCase());
        sb.append(",THE LAST NAME IS:").append(lastName.toUpperCase());
        if (subjects.size() > 1) {
            sb.append(",THE SUBJECTS ARE:");

        } else {
            sb.append(",THE SUBJECT IS:");
        }
        sb.append(subjects.stream()
                .map(s -> s.getName().toUpperCase())
                .collect(Collectors.joining(",")));

        return sb.toString();
    }
}
