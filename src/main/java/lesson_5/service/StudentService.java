package lesson_5.service;


import lesson_5.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student getById(Long id);

    void add(Student student);

    void edit(Student student);

    void deleteById(Long id);

    void deleteAll();
}
