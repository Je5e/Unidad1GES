package GES.Entities;

public class Student {
    private static int Id = 0;
    private String firstName;
    private String lastName;
    private byte grade;

    public Student(String firstName, byte grade) {
        this.firstName = firstName;
        // this.lastName=lastName;
        this.grade = grade;
        Id += 1;
    }

    public byte getGrade() {
        return grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
