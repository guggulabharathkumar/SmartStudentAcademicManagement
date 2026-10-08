package model;

@FunctionalInterface
public interface StudentAction {

    void perform(Student student);
}