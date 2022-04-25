package model;

import java.time.LocalDate;
import java.util.Objects;


public class Assignment {

    private String title;
    private String description;
    private LocalDate subDateTime;
    private String oralMark;
    private String totalMark;
    private static volatile int count;

    public Assignment(String title, String description, LocalDate subDateTime, String oralMark, String totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDateTime = subDateTime;
    }

    public String getOralMark() {
        return oralMark;
    }

    public void setOralMark(String oralMark) {
        this.oralMark = oralMark;
    }

    public String getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(String totalMark) {
        this.totalMark = totalMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return title.equalsIgnoreCase(that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(++count + "-");
        sb.append("THE TITLE IS:").append(title.toUpperCase());
        sb.append(",THE DESCRIPTION IS:").append(description.toUpperCase());
        sb.append(",THE SUBMISSION DATE IS:").append(subDateTime);
        sb.append(",THE ORAL MARK IS:").append(oralMark);
        sb.append(",THE TOTAL MARK IS:").append(totalMark);
        return sb.toString();
    }
}
