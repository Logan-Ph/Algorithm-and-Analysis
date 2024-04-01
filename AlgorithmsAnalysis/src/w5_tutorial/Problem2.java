package w5_tutorial;

public class Problem2 {

    /**
     * 
     */
    public static class RMITStudent {
        public String studentId;
        public String fullName;
        public String major;
        public double GPA;
        public RMITStudent next;

        public RMITStudent(String studentId, String fullName, String major, double GPA) {
            this.studentId = studentId;
            this.fullName = fullName;
            this.major = major;
            this.GPA = GPA;
            this.next = null;
        }
    }

    public static class RMITStudentCollection {
        public RMITStudent[] collections = new RMITStudent[13];

        public RMITStudentCollection() {
        }

        private int calculateHashCharacter(Character c) {
            if (Character.isLetter(c)) {
                return Character.toUpperCase(c) - 'A';
            } else if (Character.isDigit(c)) {
                return c - '0' + 26;
            } else {
                throw new IllegalArgumentException("Character is not a letter or digit");
            }
        }

        private int calculateHashString(String str) {
            int hashSum = 0;
            for (char c : str.toCharArray()) {
                hashSum += calculateHashCharacter(c);
            }
            return hashSum % 13;
        }

        boolean put(RMITStudent s) {
            int hashIndex = calculateHashString(s.studentId);
            return separateChainingHandleCollison(hashIndex, s);
        };

        private boolean separateChainingHandleCollison(int hashIndex, RMITStudent s) {
            if (collections[hashIndex] == null) {
                collections[hashIndex] = s;
                return true;
            } else {
                RMITStudent current = collections[hashIndex];
                while (current.next != null) {
                    current = current.next;
                }
                current.next = s;
                return true;
            }
        }

        // private boolean linearProbingHandleCollison(int hashIndex, RMITStudent s) {
        //     for (int i = hashIndex; i < hashIndex + collections.length; i++) {
        //         hashIndex = (hashIndex - collections.length < 0) ? hashIndex : hashIndex - collections.length - 1;
        //         if (collections[hashIndex] == null) {
        //             collections[hashIndex] = s;
        //             return true;
        //         }
        //     }
        //     return false;
        // }

        RMITStudent get(String studentId) {
            return (collections[calculateHashString(studentId)] != null) ? collections[calculateHashString(studentId)]
                    : null;
        };

        public boolean removeSeparateChaining(String studentId) {
            int hashIndex = calculateHashString(studentId);
            if (collections[hashIndex] != null && collections[hashIndex].studentId.equals(studentId)) {
                collections[hashIndex] = collections[hashIndex].next;
                return true;
            } else {
                RMITStudent current = collections[hashIndex];
                while (current.next != null) {
                    if (current.next.studentId.equals(studentId)) {
                        current.next = current.next.next;
                        return true;
                    }
                    current = current.next;
                }
            }
            return false;
        }

        public boolean removeLinearProbing(String studentId) {
            int hashIndex = calculateHashString(studentId);
            for (int i = hashIndex; i < hashIndex + collections.length; i++) {
                hashIndex = (hashIndex - collections.length < 0) ? hashIndex : hashIndex - collections.length - 1;
                if (collections[hashIndex] != null && collections[hashIndex].studentId.equals(studentId)) {
                    collections[hashIndex] = null;
                    return true;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        // Test Case 1: Put and Get a Student
        RMITStudentCollection collection1 = new RMITStudentCollection();
        RMITStudent student1 = new RMITStudent("s123", "John Doe", "Computer Science", 3.5);
        collection1.put(student1);
        RMITStudent retrievedStudent1 = collection1.get("s123");
        if (retrievedStudent1 == student1) {
            System.out.println("Test Case 1 Passed: Student retrieved successfully.");
        } else {
            System.out.println("Test Case 1 Failed: Student retrieval failed.");
        }

        // Test Case 2: Put and Remove a Student
        RMITStudentCollection collection2 = new RMITStudentCollection();
        RMITStudent student2 = new RMITStudent("s123", "John Doe", "Computer Science", 3.5);
        collection2.put(student2);
        collection2.removeSeparateChaining("s123");
        RMITStudent retrievedStudent2 = collection2.get("s123");
        if (retrievedStudent2 == null) {
            System.out.println("Test Case 2 Passed: Student removed successfully.");
        } else {
            System.out.println("Test Case 2 Failed: Student removal failed.");
        }

        // Test Case 3: Put and Get a Student with Collision Handling
        RMITStudentCollection collection3 = new RMITStudentCollection();
        RMITStudent student3 = new RMITStudent("s123", "John Doe", "Computer Science", 3.5);
        RMITStudent student4 = new RMITStudent("s456", "Jane Smith", "Mathematics", 3.8);
        collection3.put(student3);
        collection3.put(student4);
        RMITStudent retrievedStudent3 = collection3.get("s123");
        RMITStudent retrievedStudent4 = collection3.get("s456");
        if (retrievedStudent3 == student3 && retrievedStudent4 == student4) {
            System.out.println("Test Case 3 Passed: Students retrieved successfully with collision handling.");
        } else {
            System.out.println("Test Case 3 Failed: Student retrieval failed with collision handling.");
        }

        // Test Case 4: Put and Remove a Student with Collision Handling
        RMITStudentCollection collection4 = new RMITStudentCollection();
        RMITStudent student5 = new RMITStudent("s123", "John Doe", "Computer Science", 3.5);
        RMITStudent student6 = new RMITStudent("s456", "Jane Smith", "Mathematics", 3.8);
        collection4.put(student5);
        collection4.put(student6);
        collection4.removeSeparateChaining("s123");
        RMITStudent retrievedStudent5 = collection4.get("s123");
        RMITStudent retrievedStudent6 = collection4.get("s456");
        if (retrievedStudent5 == null && retrievedStudent6 == student6) {
            System.out.println("Test Case 4 Passed: Student removed successfully with collision handling.");
        } else {
            System.out.println("Test Case 4 Failed: Student removal failed with collision handling.");
        }

        // Test Case 5: Put and Get a Student with Linear Probing
        RMITStudentCollection collection5 = new RMITStudentCollection();
        RMITStudent student7 = new RMITStudent("s123", "John Doe", "Computer Science", 3.5);
        RMITStudent student8 = new RMITStudent("s456", "Jane Smith", "Mathematics", 3.8);
        collection5.put(student7);
        collection5.put(student8);
        RMITStudent retrievedStudent7 = collection5.get("s123");
        RMITStudent retrievedStudent8 = collection5.get("s456");
        if (retrievedStudent7 == student7 && retrievedStudent8 == student8) {
            System.out.println("Test Case 5 Passed: Students retrieved successfully with linear probing.");
        } else {
            System.out.println("Test Case 5 Failed: Student retrieval failed with linear probing.");
        }
    }
}
