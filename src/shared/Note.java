package shared;

public class Note {
    final private String student;
    final private double value;

    public Note(String student, double value) {
        this.student = student;
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    public String getStudent() {
        return this.student;
    }
}