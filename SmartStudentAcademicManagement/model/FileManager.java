package model;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class FileManager {

    private static String textFile =
            "data/students.txt";

    private static String binaryFile =
            "data/students.dat";

    public static void createDataFolder() {

        try {

            Path path =
                    Paths.get("data");

            if (!Files.exists(path)) {

                Files.createDirectories(path);
            }

        } catch (IOException e) {

            System.out.println(
                    "Unable to create data folder."
            );
        }
    }

    public static void saveToTextFile(
            ArrayList<Student> students) {

        createDataFolder();

        try (
                BufferedWriter writer =
                        new BufferedWriter(
                                new FileWriter(textFile)
                        )
        ) {

            for (Student student : students) {

                writer.write(
                        student.getId()
                                + ","
                                + student.getName()
                                + ","
                                + student.getDepartment()
                                + ","
                                + student.getYear()
                                + ","
                                + student.getCgpa()
                );

                writer.newLine();
            }

            System.out.println(
                    "Student data saved to students.txt"
            );

        } catch (IOException e) {

            System.out.println(
                    "Error while saving text file: "
                            + e.getMessage()
            );
        }
    }

    public static void readTextFile() {

        createDataFolder();

        Path path =
                Paths.get(textFile);

        if (!Files.exists(path)) {

            System.out.println(
                    "students.txt does not exist."
            );

            return;
        }

        System.out.println(
                "\n--- Data From students.txt ---"
        );

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(textFile)
                        )
        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

        } catch (IOException e) {

            System.out.println(
                    "Error while reading file: "
                            + e.getMessage()
            );
        }
    }

    public static void saveUsingNIO(
            ArrayList<Student> students) {

        createDataFolder();

        Path path =
                Paths.get(
                        "data/students_nio.txt"
                );

        ArrayList<String> lines =
                new ArrayList<>();

        for (Student student : students) {

            lines.add(
                    student.getId()
                            + " | "
                            + student.getName()
                            + " | "
                            + student.getDepartment()
                            + " | "
                            + student.getYear()
                            + " | "
                            + student.getCgpa()
            );
        }

        try {

            Files.write(
                    path,
                    lines
            );

            System.out.println(
                    "Data saved using Java NIO."
            );

        } catch (IOException e) {

            System.out.println(
                    "NIO error: "
                            + e.getMessage()
            );
        }
    }

    public static void readUsingNIO() {

        Path path =
                Paths.get(
                        "data/students_nio.txt"
                );

        if (!Files.exists(path)) {

            System.out.println(
                    "NIO file does not exist."
            );

            return;
        }

        System.out.println(
                "\n--- Data Using NIO ---"
        );

        try {

            ArrayList<String> lines =
                    new ArrayList<>(
                            Files.readAllLines(path)
                    );

            for (String line : lines) {

                System.out.println(line);
            }

        } catch (IOException e) {

            System.out.println(
                    "NIO reading error: "
                            + e.getMessage()
            );
        }
    }

    public static void serializeStudents(
            ArrayList<Student> students) {

        createDataFolder();

        try (
                FileOutputStream fos =
                        new FileOutputStream(binaryFile);

                ObjectOutputStream oos =
                        new ObjectOutputStream(fos)
        ) {

            oos.writeObject(students);

            System.out.println(
                    "Student data serialized successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Serialization error: "
                            + e.getMessage()
            );
        }
    }

    public static ArrayList<Student>
    deserializeStudents() {

        createDataFolder();

        File file =
                new File(binaryFile);

        if (!file.exists()) {

            return new ArrayList<>();
        }

        try (
                FileInputStream fis =
                        new FileInputStream(binaryFile);

                ObjectInputStream ois =
                        new ObjectInputStream(fis)
        ) {

            ArrayList<Student> students =
                    (ArrayList<Student>) ois.readObject();

            System.out.println(
                    "Student data loaded successfully."
            );

            return students;

        } catch (IOException |
                 ClassNotFoundException e) {

            System.out.println(
                    "Deserialization error: "
                            + e.getMessage()
            );

            return new ArrayList<>();
        }
    }
}