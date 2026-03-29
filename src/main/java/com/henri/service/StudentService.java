package com.henri.service;

import com.henri.dao.StudentDAO;
import com.henri.enums.WorkMode;
import com.henri.model.Student;
import com.henri.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService implements StudentDAO {

    // private final List<Student> STUDENT_LIST = new ArrayList<>();


        private final UserService userService; // gebruikt DEZELFDE lijst

        public StudentService(UserService userService) {
            this.userService = userService;
        }

        @Override
        public Student createStudent(Student student) {
            return (Student) userService.createNewUser(student);
        }

        @Override
        public void updateStudent(Student student) {
            userService.updateUser(student);
        }

        @Override
        public void deleteStudent(Student student) {
            userService.deleteUser(student); // verwijdert uit dezelfde lijst
        }
        @Override
        public List<Student> getAllStudents() {
            return userService.getAllUsers().stream()
                    .filter(u -> u instanceof Student)
                    .map(u -> (Student) u)
                    .collect(Collectors.toList());
        }

     @Override
    public Student findStudentById(int studentId) {
        return userService.getAllUsers().stream()
                .filter(user -> user instanceof Student)
                .map(user -> (Student) user)
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> findStudentsBySkill(String skill) {
        List<Student> result = new ArrayList<>();

        for (User user : userService.getAllUsers()) {
            if (user instanceof Student) {
                Student s = (Student) user;
                if (s.getSkills() != null && s.getSkills().contains(skill)) {
                    result.add(s);
                }
            }
        }

        return result;
    }

    @Override
    public List<Student> findStudentsByWorkModel(WorkMode workMode) {
        List<Student> result = new ArrayList<>();

        for (User user : userService.getAllUsers()) {
            if (user instanceof Student) {
                Student s = (Student) user;
                if (workMode.equals(s.getWorkMode())) {
                    result.add(s);
                }
            }
        }

        return result;
    }


}
