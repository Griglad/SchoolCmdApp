package model;


import java.util.*;

public enum Stream {

    FIRST("JAVA"),
    SECOND("C#"),
    THIRD("PYTHON"),
    FOURTH("JAVASCRIPT"),
    FIFTH("RUBY"),
    SIXTH("GO"),
    SEVENTH("SWIFT");

    private static final Map<String, Stream> BY_LABEL = new HashMap<>();

    private String name;

    private List<Type> types = new ArrayList<>();

    static {
        for (Stream e : values()) {
            BY_LABEL.put(e.name, e);
        }
    }

    Stream(String name) {
        this.name = name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static Set<String> getStreamNames() {
        return BY_LABEL.keySet();
    }

    public static Collection<Stream> getStreams() {
        return BY_LABEL.values();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stream{");
        sb.append("name='").append(name).append('\'');
        if (types.size() > 1) {
            sb.append("types=").append(types);
        } else {
            sb.append("type=").append(types);
        }
        sb.append('}');
        return sb.toString();
    }

    public static Stream valueOfLabel(String label) {
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




}
