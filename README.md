# Smart Student Academic Management System

A Core Java based console application for managing student academic information, performance, reports, collections, and file storage.

## Project Overview

The Smart Student Academic Management System is a Java Programming Lab project developed using Core Java.

The application allows users to:

- Add student details
- View student records
- Search students by ID
- Update student information
- Delete student records
- Calculate academic performance
- Display academic status
- Generate academic reports using multithreading
- Demonstrate Java Collections Framework
- Demonstrate Java 8 features
- Save student data to files
- Read student data from files
- Perform serialization and deserialization
- Demonstrate Java NIO file operations

## Features

### Student Management

- Add Student
- View Students
- Search Student
- Update Student
- Delete Student

### Academic Management

- Calculate student performance based on CGPA
- Display academic status
- Generate academic reports

### Java Collections

The project demonstrates:

- ArrayList
- LinkedList
- HashSet
- TreeSet
- HashMap
- TreeMap
- Iterator

### Java 8 Features

The project demonstrates:

- Functional Interface
- Lambda Expressions
- forEach()
- Method References
- Comparator
- Comparable

### Exception Handling

The project includes:

- try-catch
- Multiple catch
- finally
- Custom Exceptions
- throw
- throws

Custom exceptions:

- InvalidStudentIdException
- InvalidCGPAException

### Multithreading

Academic reports are generated using:

- Thread
- Runnable
- Thread synchronization
- Thread.join()

### File Handling

The project demonstrates:

- FileReader
- FileWriter
- BufferedReader
- BufferedWriter
- FileInputStream
- FileOutputStream
- ObjectInputStream
- ObjectOutputStream

### Serialization

Student objects are serialized and stored in:

`students.dat`

The stored objects can later be loaded using deserialization.

### Java NIO

The project also demonstrates:

- Path
- Paths
- Files
- Files.write()
- Files.readAllLines()
- Files.exists()
- Files.createDirectories()

## Technologies Used

- Java
- Core Java
- Java Collections Framework
- Java 8
- Java IO
- Java NIO
- Multithreading
- Serialization

## Project Structure

```text
SmartStudentAcademicManagement
│
├── main
│   └── Main.java
│
├── model
│   ├── Person.java
│   ├── Student.java
│   ├── AcademicOperations.java
│   ├── InvalidCGPAException.java
│   ├── InvalidStudentIdException.java
│   ├── ReportGenerator.java
│   ├── StudentAction.java
│   ├── StudentManager.java
│   └── FileManager.java
│
├── data
│   ├── students.txt
│   ├── students.dat
│   └── students_nio.txt
│
└── README.md
