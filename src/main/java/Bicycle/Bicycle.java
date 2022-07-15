package Bicycle;

public class Bicycle {

    private String codeCycle;
    private String type;
    private String color;
    private boolean available;



    public Bicycle(String codeCycle, String type, String color, boolean available) {
        this.codeCycle = codeCycle;
        this.type = type;
        this.color = color;
        this.available = available;
    }

    public String getCodeCycle() {
        return codeCycle;
    }

    public void setCodeCycle(String codeCycle) {
        this.codeCycle = codeCycle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "codeCycle='" + codeCycle + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", available=" + available +
                "}\n";
    }
}
