package model;

public class Student extends Person
        implements AcademicOperations, Comparable<Student> {

    public static String collegeName =
            "Chaitanya Bharathi Institute of Technology";

    public final String course =
            "B.E. Information Technology and Engineering";

    private int id;
    private String department;
    private int year;
    private double cgpa;

    public Student() {
        super("Unknown");
        id = 0;
        department = "Unknown";
        year = 0;
        cgpa = 0.0;
    }

    public Student(int id, String name) {
        super(name);
        this.id = id;
        department = "Not Assigned";
        year = 1;
        cgpa = 0.0;
    }

    public Student(int id, String name, String department,
                   int year, double cgpa)
            throws InvalidStudentIdException,
            InvalidCGPAException {

        super(name);

        setId(id);
        this.department = department;
        this.year = year;
        setCgpa(cgpa);
    }

    public void setId(int id)
            throws InvalidStudentIdException {

        if (id <= 0) {
            throw new InvalidStudentIdException(
                    "Student ID must be greater than 0."
            );
        }

        this.id = id;
    }

    public void setCgpa(double cgpa)
            throws InvalidCGPAException {

        if (cgpa < 0 || cgpa > 10) {
            throw new InvalidCGPAException(
                    "CGPA must be between 0 and 10."
            );
        }

        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getYear() {
        return year;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayCollege() {

        System.out.println(
                "College: " + collegeName
        );

        System.out.println(
                "Course: " + course
        );
    }

    @Override
    public void displayInfo() {

        System.out.println(
                "ID: " + id
        );

        System.out.println(
                "Name: " + name
        );

        System.out.println(
                "Department: " + department
        );

        System.out.println(
                "Year: " + year
        );

        System.out.println(
                "CGPA: " + cgpa
        );
    }

    @Override
    public void calculatePerformance() {

        if (cgpa >= 9.0) {

            System.out.println(
                    "Performance: Excellent"
            );

        } else if (cgpa >= 8.0) {

            System.out.println(
                    "Performance: Very Good"
            );

        } else if (cgpa >= 7.0) {

            System.out.println(
                    "Performance: Good"
            );

        } else {

            System.out.println(
                    "Performance: Needs Improvement"
            );
        }
    }

    @Override
    public void displayAcademicStatus() {

        if (cgpa >= 7.0) {

            System.out.println(
                    "Academic Status: Good Standing"
            );

        } else {

            System.out.println(
                    "Academic Status: Needs Improvement"
            );
        }
    }

    @Override
    public int compareTo(Student other) {

        return this.id - other.id;
    }

    @Override
    public String toString() {

        return id + " - " +
                name + " - " +
                department + " - " +
                year + " - " +
                cgpa;
    }
}