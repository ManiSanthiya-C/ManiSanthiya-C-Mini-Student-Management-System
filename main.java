import java.util.ArrayList;

/*
 * Mini Student Management System
 * Demonstrates: Classes, Objects, Encapsulation, Inheritance, Polymorphism, Methods, Loops, Recursion
 */
class Student {
    private String name;
    private int age;
    private int marks;

    // Constructor
    Student(String name, int age, int marks){
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getMarks() { return marks; }

    // Display student information
    void displayInfo() {
        System.out.println(name + " | Age: " + age + " | Marks: " + marks);
    }
}

// Child class for Graduate Students (Inheritance + Polymorphism)
class GraduateStudent extends Student {
    private String degree;

    GraduateStudent(String name, int age, int marks, String degree){
        super(name, age, marks);
        this.degree = degree;
    }

    // Overriding displayInfo (Polymorphism)
    @Override
    void displayInfo() {
        System.out.println(getName() + " | Age: " + getAge() + " | Marks: " + getMarks() + " | Degree: " + degree);
    }
}

public class MiniStudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // Pre-filled students (No input required)
        students.add(new Student("Shona", 21, 95));
        students.add(new GraduateStudent("Angel", 22, 98, "M.Tech"));
        students.add(new Student("Arun", 20, 90));

        // Display all students
        System.out.println("============================");
        System.out.println("       STUDENT LIST");
        System.out.println("============================");
        int count = 1;
        for(Student s : students) {
            System.out.print(count + ". ");
            s.displayInfo();
            count++;
        }
        System.out.println("----------------------------\n");

        // Find top scorer recursively
        Student top = findTopScorer(students, 0, null);
        System.out.println("Top Scorer:");
        top.displayInfo();
        System.out.println("============================");
    }

    // Recursive method to find the student with highest marks
    static Student findTopScorer(ArrayList<Student> list, int index, Student top) {
        if(index == list.size()) return top;
        if(top == null || list.get(index).getMarks() > top.getMarks()) {
            top = list.get(index);
        }
        return findTopScorer(list, index + 1, top);
    }
}
