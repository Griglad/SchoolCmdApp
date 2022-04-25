package model;

import utilities.Stream;
import utilities.Type;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Course {

    private String title;
    private List<Stream> streams;
    private List<Type> types;
    private LocalDate start_date;
    private LocalDate end_date;
    private static volatile int count;

    public Course() {

    }

    public Course(String title, List<Stream> streams, List<Type> types, LocalDate start_date, LocalDate end_date) {
        this.title = title;
        this.streams = streams;
        this.types = types;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Stream> getStreams() {
        return streams;
    }

    public void setStreams(List<Stream> streams) {
        this.streams = streams;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return title.equalsIgnoreCase(course.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        int countNumOfStreams = streams.size();
        int countOfTypes = types.size();
        final StringBuilder sb = new StringBuilder();
        sb.append(++count + "-");
        sb.append("THE COURSE TITLE IS:").append(title);
        if (countNumOfStreams > 1) {
            sb.append(",THE STREAMS ARE:");
        } else {
            sb.append(",THE STREAM IS:");
        }
        sb.append(streams.stream()
                .map(s -> s.getName().toUpperCase()).collect(Collectors.joining(",")));
        if (countOfTypes > 1) {
            sb.append(",THE TYPES ARE:");
        } else {
            sb.append(",THE TYPE IS:");
        }
        sb.append(types.stream()
                .map(t -> t.getName().toUpperCase()).collect(Collectors.joining(",")));
        sb.append(",THE START DATE IS:").append(start_date);
        sb.append(",THE END DATE IS:").append(end_date);
        return sb.toString();
    }
}
