package model;

public class ReportGenerator implements Runnable {

    private Student student;

    public ReportGenerator(Student student) {
        this.student = student;
    }

    @Override
    public void run() {

        generateReport();
    }

    public synchronized void generateReport() {

        System.out.println(
                "\nGenerating report for "
                        + student.getName()
        );

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {

            System.out.println(
                    "Report generation interrupted."
            );
        }

        System.out.println(
                "Student ID: "
                        + student.getId()
        );

        System.out.println(
                "CGPA: "
                        + student.getCgpa()
        );

        student.calculatePerformance();

        student.displayAcademicStatus();

        System.out.println(
                "Report completed for "
                        + student.getName()
        );
    }
}