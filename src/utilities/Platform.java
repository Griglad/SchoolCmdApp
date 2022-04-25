package utilities;

public enum Platform {

    SYNTHETIC("SyntheticData"),
    DATABASE("Database");

    private String type;

    Platform(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
