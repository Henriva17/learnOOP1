package com.henri.dao;

import com.henri.enums.WorkMode;
import com.henri.model.Student;

import java.util.List;

public interface StudentDAO {
    Student createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
    List<Student> getAllStudents();
    Student findStudentById(int studentId);
    List<Student> findStudentsBySkill(String skills);
    List<Student> findStudentsByWorkModel(WorkMode workMode);

}
