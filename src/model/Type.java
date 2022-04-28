package model;

import java.util.*;

public enum Type {

    FULLTIME("FULL TIME"), PARTTIME("PART TIME");

    private static final Map<String, Type> BY_LABEL = new HashMap<>();

    private String name;

    static {
        for (Type e : values()) {
            BY_LABEL.put(e.name, e);
        }
    }

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Set<String> getTypeNames() {
        return BY_LABEL.keySet();
    }

    public static Collection<Type> getTypes(){
        return BY_LABEL.values();
    }

    public static Type valueOfLabel(String label) {
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
