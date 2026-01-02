import java.util.ArrayList;
import java.util.Scanner;

abstract class Person {
    protected int id;
    protected String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract void displayInfo();
}

class Student extends Person {

    private int age;
    private String course;

    Student(int id, String name, int age, String course) {
        super(id, name);
        this.age = age;
        this.course = course;
    }

    int getId() {
        return id;
    }

    void setAge(int age) {
        this.age = age;
    }

    void setCourse(String course) {
        this.course = course;
    }

    public void displayInfo() {
        System.out.println(
            "ID: " + id +
            ", Name: " + name +
            ", Age: " + age +
            ", Course: " + course
        );
    }
}

interface StudentService {
    void addStudent(Student s);
    void viewStudents();
    void updateStudent(int id, String name, int age, String course);
    void deleteStudent(int id);
}

class StudentServiceImpl implements StudentService {

    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available");
            return;
        }

        for (Student s : students) {
            s.displayInfo();
        }
    }

    public void updateStudent(int id, String name, int age, String course) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setAge(age);
                s.setCourse(course);
                System.out.println("Student updated successfully");
                return;
            }
        }
        System.out.println("Student not found");
    }

    public void deleteStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student deleted successfully");
                return;
            }
        }
        System.out.println("Student not found");
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentServiceImpl();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    service.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    service.updateStudent(uid, newName, newAge, newCourse);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    service.deleteStudent(did);
                    break;

                case 5:
                    System.out.println("Program ended");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
