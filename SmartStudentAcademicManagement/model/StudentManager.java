package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Comparator;

public class StudentManager<T extends Student> {

    private ArrayList<T> students;

    public StudentManager() {

        students = new ArrayList<>();
    }

    public void add(T student) {

        students.add(student);
    }

    public ArrayList<T> getStudents() {

        return students;
    }

    public void setStudents(ArrayList<T> students) {

        this.students = students;
    }

    public void displayArrayList() {

        System.out.println(
                "\n--- ArrayList ---"
        );

        for (T student : students) {

            System.out.println(student);
        }
    }

    public void displayLinkedList() {

        LinkedList<T> list =
                new LinkedList<>();

        list.addAll(students);

        System.out.println(
                "\n--- LinkedList ---"
        );

        for (T student : list) {

            System.out.println(student);
        }
    }

    public void displayHashSet() {

        HashSet<Integer> ids =
                new HashSet<>();

        for (T student : students) {

            ids.add(student.getId());
        }

        System.out.println(
                "\n--- HashSet ---"
        );

        for (Integer id : ids) {

            System.out.println(
                    "Student ID: " + id
            );
        }
    }

    public void displayTreeSet() {

        TreeSet<Integer> ids =
                new TreeSet<>();

        for (T student : students) {

            ids.add(student.getId());
        }

        System.out.println(
                "\n--- TreeSet ---"
        );

        for (Integer id : ids) {

            System.out.println(
                    "Student ID: " + id
            );
        }
    }

    public void displayHashMap() {

        HashMap<Integer, String> map =
                new HashMap<>();

        for (T student : students) {

            map.put(
                    student.getId(),
                    student.getName()
            );
        }

        System.out.println(
                "\n--- HashMap ---"
        );

        for (Integer id : map.keySet()) {

            System.out.println(
                    "ID: " + id +
                    ", Name: " + map.get(id)
            );
        }
    }

    public void displayTreeMap() {

        TreeMap<Integer, String> map =
                new TreeMap<>();

        for (T student : students) {

            map.put(
                    student.getId(),
                    student.getName()
            );
        }

        System.out.println(
                "\n--- TreeMap ---"
        );

        for (Integer id : map.keySet()) {

            System.out.println(
                    "ID: " + id +
                    ", Name: " + map.get(id)
            );
        }
    }

    public void displayIterator() {

        System.out.println(
                "\n--- Iterator ---"
        );

        Iterator<T> iterator =
                students.iterator();

        while (iterator.hasNext()) {

            T student =
                    iterator.next();

            System.out.println(student);
        }
    }

    public void sortById() {

        ArrayList<T> list =
                new ArrayList<>(students);

        list.sort(null);

        System.out.println(
                "\n--- Sorted By ID ---"
        );

        for (T student : list) {

            System.out.println(student);
        }
    }

    public void sortByName() {

        ArrayList<T> list =
                new ArrayList<>(students);

        list.sort(
                Comparator.comparing(
                        Student::getName
                )
        );

        System.out.println(
                "\n--- Sorted By Name ---"
        );

        for (T student : list) {

            System.out.println(student);
        }
    }

    public void sortByCGPA() {

        ArrayList<T> list =
                new ArrayList<>(students);

        list.sort(
                Comparator.comparingDouble(
                        Student::getCgpa
                ).reversed()
        );

        System.out.println(
                "\n--- Sorted By CGPA ---"
        );

        for (T student : list) {

            System.out.println(student);
        }
    }

    public void performAction(StudentAction action) {

        for (T student : students) {

            action.perform(student);
        }
    }

    public void displayUsingForEach() {

        System.out.println(
                "\n--- forEach Lambda ---"
        );

        students.forEach(
                student ->
                        System.out.println(student)
        );
    }

    public void displayNamesUsingMethodReference() {

        System.out.println(
                "\n--- Method Reference ---"
        );

        students.forEach(
                System.out::println
        );
    }
}