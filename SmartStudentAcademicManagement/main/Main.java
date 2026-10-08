package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Person;
import model.Student;
import model.ReportGenerator;
import model.StudentManager;
import model.FileManager;
import model.InvalidCGPAException;
import model.InvalidStudentIdException;

public class Main {

    static ArrayList<Student> students =
            new ArrayList<>();

    static StudentManager<Student> manager =
            new StudentManager<>();

    static Scanner sc =
            new Scanner(System.in);

    public static void main(String[] args) {

        students =
                FileManager.deserializeStudents();

        manager.setStudents(students);

        while (true) {

            try {

                System.out.println(
                        "\n========================================"
                );

                System.out.println(
                        " SMART STUDENT ACADEMIC MANAGEMENT"
                );

                System.out.println(
                        "========================================"
                );

                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Academic Performance");
                System.out.println("7. Display College Details");
                System.out.println("8. Generate Academic Reports");
                System.out.println("9. Collections Demo");
                System.out.println("10. Java 8 Demo");
                System.out.println("11. Save Data");
                System.out.println("12. Read Text File");
                System.out.println("13. NIO File Demo");
                System.out.println("14. Serialization");
                System.out.println("15. Exit");

                System.out.print(
                        "\nEnter your choice: "
                );

                int choice =
                        sc.nextInt();

                switch (choice) {

                    case 1:
                        addStudent();
                        break;

                    case 2:
                        viewStudents();
                        break;

                    case 3:
                        searchStudent();
                        break;

                    case 4:
                        updateStudent();
                        break;

                    case 5:
                        deleteStudent();
                        break;

                    case 6:
                        academicPerformance();
                        break;

                    case 7:
                        displayCollegeDetails();
                        break;

                    case 8:
                        generateReports();
                        break;

                    case 9:
                        collectionsDemo();
                        break;

                    case 10:
                        java8Demo();
                        break;

                    case 11:
                        saveData();
                        break;

                    case 12:
                        FileManager.readTextFile();
                        break;

                    case 13:
                        nioDemo();
                        break;

                    case 14:
                        serializationDemo();
                        break;

                    case 15:

                        FileManager.serializeStudents(
                                students
                        );

                        System.out.println(
                                "Thank you for using the system."
                        );

                        sc.close();

                        return;

                    default:

                        System.out.println(
                                "Invalid choice."
                        );
                }

            } catch (Exception e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );

                sc.nextLine();

            } finally {

                System.out.println(
                        "Operation completed."
                );
            }
        }
    }

    static void addStudent() {

        try {

            System.out.println(
                    "\n--- Add Student ---"
            );

            System.out.print(
                    "Enter Student ID: "
            );

            int id =
                    sc.nextInt();

            sc.nextLine();

            System.out.print(
                    "Enter Student Name: "
            );

            String name =
                    sc.nextLine();

            System.out.print(
                    "Enter Department: "
            );

            String department =
                    sc.nextLine();

            System.out.print(
                    "Enter Year: "
            );

            int year =
                    sc.nextInt();

            System.out.print(
                    "Enter CGPA: "
            );

            double cgpa =
                    sc.nextDouble();

            Student student =
                    new Student(
                            id,
                            name,
                            department,
                            year,
                            cgpa
                    );

            students.add(student);

            manager.add(student);

            System.out.println(
                    "\nStudent added successfully."
            );

            student.displayInfo();

        } catch (InvalidStudentIdException e) {

            System.out.println(
                    "Invalid Student ID: "
                            + e.getMessage()
            );

        } catch (InvalidCGPAException e) {

            System.out.println(
                    "Invalid CGPA: "
                            + e.getMessage()
            );

        } catch (Exception e) {

            System.out.println(
                    "Invalid input."
            );

            sc.nextLine();
        }
    }

    static void viewStudents() {

        System.out.println(
                "\n--- Student List ---"
        );

        if (students.isEmpty()) {

            System.out.println(
                    "No students found."
            );

            return;
        }

        for (Student student : students) {

            System.out.println(
                    "----------------------------"
            );

            student.displayInfo();
        }

        System.out.println(
                "----------------------------"
        );
    }

    static void searchStudent() {

        System.out.println(
                "\n--- Search Student ---"
        );

        System.out.print(
                "Enter Student ID: "
        );

        int id =
                sc.nextInt();

        boolean found = false;

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println(
                        "\nStudent Found"
                );

                student.displayInfo();

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println(
                    "Student not found."
            );
        }
    }

    static void updateStudent() {

        try {

            System.out.println(
                    "\n--- Update Student ---"
            );

            System.out.print(
                    "Enter Student ID: "
            );

            int id =
                    sc.nextInt();

            boolean found = false;

            for (Student student : students) {

                if (student.getId() == id) {

                    sc.nextLine();

                    System.out.print(
                            "Enter New Name: "
                    );

                    student.setName(
                            sc.nextLine()
                    );

                    System.out.print(
                            "Enter New Department: "
                    );

                    student.setDepartment(
                            sc.nextLine()
                    );

                    System.out.print(
                            "Enter New Year: "
                    );

                    student.setYear(
                            sc.nextInt()
                    );

                    System.out.print(
                            "Enter New CGPA: "
                    );

                    double cgpa =
                            sc.nextDouble();

                    student.setCgpa(cgpa);

                    System.out.println(
                            "Student updated successfully."
                    );

                    found = true;

                    break;
                }
            }

            if (!found) {

                System.out.println(
                        "Student not found."
                );
            }

        } catch (InvalidCGPAException e) {

            System.out.println(
                    "Invalid CGPA: "
                            + e.getMessage()
            );

        } catch (Exception e) {

            System.out.println(
                    "Invalid input."
            );

            sc.nextLine();
        }
    }

    static void deleteStudent() {

        System.out.println(
                "\n--- Delete Student ---"
        );

        System.out.print(
                "Enter Student ID: "
        );

        int id =
                sc.nextInt();

        boolean found = false;

        for (int i = 0;
             i < students.size();
             i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);

                System.out.println(
                        "Student deleted successfully."
                );

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println(
                    "Student not found."
            );
        }
    }

    static void academicPerformance() {

        System.out.println(
                "\n--- Academic Performance ---"
        );

        System.out.print(
                "Enter Student ID: "
        );

        int id =
                sc.nextInt();

        boolean found = false;

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.println(
                        "Student: "
                                + student.getName()
                );

                student.calculatePerformance();

                student.displayAcademicStatus();

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println(
                    "Student not found."
            );
        }
    }

    static void displayCollegeDetails() {

        System.out.println(
                "\n--- College Details ---"
        );

        System.out.println(
                "College: "
                        + Student.collegeName
        );

        System.out.println(
                "Course: B.E. Information Technology and Engineering"
        );
    }

    static void generateReports() {

        System.out.println(
                "\n--- Academic Report Generation ---"
        );

        if (students.isEmpty()) {

            System.out.println(
                    "No students available."
            );

            return;
        }

        ArrayList<Thread> threads =
                new ArrayList<>();

        for (Student student : students) {

            ReportGenerator report =
                    new ReportGenerator(student);

            Thread thread =
                    new Thread(report);

            threads.add(thread);

            thread.start();
        }

        for (Thread thread : threads) {

            try {

                thread.join();

            } catch (InterruptedException e) {

                System.out.println(
                        "Thread interrupted."
                );
            }
        }

        System.out.println(
                "\nAll academic reports generated."
        );
    }

    static void collectionsDemo() {

        System.out.println(
                "\n========================================"
        );

        System.out.println(
                " COLLECTIONS FRAMEWORK DEMO"
        );

        System.out.println(
                "========================================"
        );

        if (students.isEmpty()) {

            System.out.println(
                    "Add students first."
            );

            return;
        }

        manager.displayArrayList();

        manager.displayLinkedList();

        manager.displayHashSet();

        manager.displayTreeSet();

        manager.displayHashMap();

        manager.displayTreeMap();

        manager.displayIterator();

        manager.sortById();

        manager.sortByName();

        manager.sortByCGPA();
    }

    static void java8Demo() {

        System.out.println(
                "\n========================================"
        );

        System.out.println(
                " JAVA 8 FEATURES DEMO"
        );

        System.out.println(
                "========================================"
        );

        if (students.isEmpty()) {

            System.out.println(
                    "Add students first."
            );

            return;
        }

        manager.displayUsingForEach();

        manager.displayNamesUsingMethodReference();

        System.out.println(
                "\n--- Lambda: Students with CGPA >= 8 ---"
        );

        manager.performAction(
                student -> {

                    if (student.getCgpa() >= 8.0) {

                        System.out.println(
                                student.getName()
                        );
                    }
                }
        );

        System.out.println(
                "\n--- Lambda: Student Names ---"
        );

        manager.performAction(
                student ->
                        System.out.println(
                                "Name: "
                                        + student.getName()
                        )
        );

        System.out.println(
                "\n--- Lambda: Student CGPA ---"
        );

        manager.performAction(
                student ->
                        System.out.println(
                                student.getName()
                                        + " -> "
                                        + student.getCgpa()
                        )
        );
    }

    static void saveData() {

        FileManager.saveToTextFile(
                students
        );

        FileManager.serializeStudents(
                students
        );

        System.out.println(
                "All student data saved."
        );
    }

    static void nioDemo() {

        System.out.println(
                "\n--- Java NIO Demo ---"
        );

        FileManager.saveUsingNIO(
                students
        );

        FileManager.readUsingNIO();
    }

    static void serializationDemo() {

        System.out.println(
                "\n--- Serialization Demo ---"
        );

        FileManager.serializeStudents(
                students
        );

        ArrayList<Student> loadedStudents =
                FileManager.deserializeStudents();

        System.out.println(
                "\nStudents loaded from binary file:"
        );

        for (Student student : loadedStudents) {

            System.out.println(student);
        }
    }

    static void showPersonInfo(Person person) {

        person.displayInfo();
    }
}