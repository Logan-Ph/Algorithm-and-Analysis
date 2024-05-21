package w5_tutorial;

public class RMITStudent {
    String studentId, fullName, major;
    double GPA;
    RMITStudent next;

    public RMITStudent(String studentId, String major, String fullName, double GPA){
        this.studentId = studentId;
        this.major = major;
        this.fullName = fullName;
        this.GPA = GPA;
        this.next = null;
    }
}
