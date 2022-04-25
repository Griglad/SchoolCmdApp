package utilities;

import java.util.*;

public enum Subject {

    JAVA("JAVA"),
    CSHARP("C#"),
    JAVASCRIPT("JAVASCRIPT"),
    C("C"),
    SQL("SQL"),
    ALGORITHMS_AND_DATA_STRUCTURES("OOP"),
    COMPUTER_SCIENCE("ALGORITHMS"),
    SOFTWARE_TESTING("NETWORKS");


    private String name;

    private static final Map<String, Subject> BY_LABEL = new HashMap<>();

    static {
        for (Subject e : values()) {
            BY_LABEL.put(e.name, e);
        }
    }

    Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Set<String> getSubjectNames() {
        return BY_LABEL.keySet();
    }


    public static Collection<Subject> getSubjects() {
        return BY_LABEL.values();
    }


    public static Subject valueOfLabel(String label) {
        String labelToFind = null;
        String labelLower = label.toLowerCase();
        Optional<String> optionalLabel = BY_LABEL
                .keySet()
                .stream()
                .filter(e -> e.toLowerCase().contains(labelLower)).findFirst();
        if (optionalLabel.isPresent()) {
            labelToFind = optionalLabel.get();
        }
        return BY_LABEL.get(labelToFind);
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Subject{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
