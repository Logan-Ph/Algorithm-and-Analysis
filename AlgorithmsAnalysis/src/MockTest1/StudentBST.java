package MockTest1;

public class StudentBST {
    public Student root;

    public StudentBST(Student student){
        this.root = student;
    }

    public void addStudent(Student student){
        this.addStudent(this.root, student);
    }

    private Student addStudent(Student root, Student currStudent){
        if (root == null) return currStudent;
    
        if (root.GPA > currStudent.GPA) root.left = addStudent(root.left, currStudent);
        if (root.GPA < currStudent.GPA) root.right = addStudent(root.right, currStudent);
        
        return root;
    }

    public Student nextStudent(Student student){
        Student curr = this.root;
        Student parent = null;

        while (curr != null) {
            if (student.GPA < curr.GPA){
                parent = curr;
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }

        return parent;
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "A", 70.0);  // the first parameter is student id
        Student s2 = new Student(2, "B", 65.0);
        Student s3 = new Student(3, "C", 80.0);
        Student s4 = new Student(4, "D", 78.0);
        Student s5 = new Student(5, "E", 68.0);
        StudentBST tree = new StudentBST(s1);
        tree.addStudent(s2);
        tree.addStudent(s3);
        tree.addStudent(s4);
        tree.addStudent(s5);

        System.out.println(tree.nextStudent(s1));
        System.out.println(tree.nextStudent(s5));
        System.out.println(tree.nextStudent(s3));

    }
}

class Student{
    public int id;
    public String name;
    public double GPA;
    public Student left, right;

    public Student(int id, String name, double GPA){
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }
    
    @Override
    public String toString() {
        return "[ " + id + ", " + name + ", " + GPA + " ]"; 
    }
}
