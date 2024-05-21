package w5_tutorial;

/**
 * RMITStudentCollecitonChainning
 */
public class RMITStudentCollecitonChainning {
    int size;
    static int N;
    RMITStudentLinkedList[] studentCollecitons;
    
    public RMITStudentCollecitonChainning(int size){
        this.studentCollecitons = new RMITStudentLinkedList[size];
    }

    public static int calculateHashCharacter(char c){
        String hashString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return hashString.indexOf(c);
    }

    public static int calculateHashString(String str){
        int total = 0;
        for (char c : str.toCharArray()){
            total += calculateHashCharacter(c);
        }

        return total % N;
    }

    public boolean put(RMITStudent student){
        int hashIndex = calculateHashString(student.studentId);
        System.out.println(hashIndex);
        if (studentCollecitons[hashIndex] == null){
            studentCollecitons[hashIndex] = new RMITStudentLinkedList(student);
            studentCollecitons[hashIndex].size++;
            return true;
        }
        return studentCollecitons[hashIndex].insert(student);
    }

    public boolean remove(RMITStudent student){
        int hashIndex = calculateHashString(student.studentId);
        if (studentCollecitons[hashIndex] == null){
            return false;
        }

        return studentCollecitons[hashIndex].remove(student.studentId);
    }

    public static void main(String[] args) {
        N = 10; // Set the size of the hash table
        RMITStudentCollecitonChainning collection = new RMITStudentCollecitonChainning(N);
    
        // Create some student instances
        RMITStudent student1 = new RMITStudent("S1234567", "John Doe", "A", 12);
        RMITStudent student2 = new RMITStudent("S1234568", "Jane Smith", "A", 12);
        RMITStudent student3 = new RMITStudent("S1234567", "John Doe", "A", 12); // Same ID as student1
    
        // Test adding students
        System.out.println("Adding Student 1: " + collection.put(student1)); // Expected: true
        System.out.println("Adding Student 2: " + collection.put(student2)); // Expected: true
        System.out.println("Adding Student 3 (duplicate ID): " + collection.put(student3)); // Expected: false due to duplicate ID
    
        // Test removing students
        System.out.println("Removing Student 1: " + collection.remove(student1)); // Expected: true
        System.out.println("Removing Student 1 again: " + collection.remove(student1)); // Expected: false, already removed
        System.out.println("Removing Student 2: " + collection.remove(student2)); // Expected: true
    }
}

class RMITStudentLinkedList {
    RMITStudent head;
    int size;

    public RMITStudentLinkedList(RMITStudent student){
        this.head = student;
    }

    public boolean insert(RMITStudent student){
        if (size == 0){
            this.head = student;
            size++;
            return true;
        }

        RMITStudent temp = this.head;
        while (temp.next != null) {
            if (temp.studentId.equals(student.studentId)){
                return false;
            }
            temp = temp.next;
        }
        temp.next = student;
        size++;
        return true;
    }

    public boolean remove(String studentId){
        if (size == 0) return false;

        if (this.head.studentId.equals(studentId)){
            this.head = this.head.next;
            size--;
            return true;
        }

        RMITStudent temp = this.head;
        while (temp.next != null) {
            if (temp.next.studentId.equals(studentId)){
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}