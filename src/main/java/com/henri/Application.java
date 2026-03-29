package com.henri;

import com.henri.enums.Role;
import com.henri.model.Student;
import com.henri.model.User;
import com.henri.service.StudentService;
import com.henri.service.UserImplement;
import com.henri.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        System.out.println("====================================================");
        System.out.println("         INTERNSHIP PLATFORM ");
        System.out.println("====================================================");

        UserService userService = new UserService();   //  Userservice implements UserDAO
        StudentService studnetService = new StudentService(); // Studentservice implements StdentDAO

        //UserImplement userImplement = new UserImplement(userService);

        User AminaAlsUser = new User(
                001,
                "Hazak Amina",
                "amina@gmail.com",
                Role.USER
        );
        AminaAlsUser.setLocation("Gehnt");
        User PerlitaAlsUser = new User(
                002,
                "Kazak Perlita",
                "perlita@gmail.com",
                Role.USER
        );
        PerlitaAlsUser.setLocation("Gehnt");
        User RadarsUser = new User(
                003,
                "Radarwerk SRL",
                "radar@gmail.com",
                Role.USER
        );
        RadarsUser.setLocation("Gehnt");

        AminaAlsUser.setBirthDate(LocalDate.of(2002,1,1));
        userService.createNewUser(AminaAlsUser);
        userService.createNewUser(PerlitaAlsUser);
        userService.createNewUser(RadarsUser);

        System.out.println("====================================================");
        System.out.println("         AMiNA becomes student ");
        System.out.println("====================================================");

        Student AminaAlsStudent = userService.promoteToStudent(
                AminaAlsUser,
                101,
                "I am a motivated student",
                "Programming",
                "Masters",
                2026,
                "Odisee-Hogeshool",
                new HashSet<>(Arrays.asList("Java", "Spring Boot", "SQL")
        ));
        System.out.println("====================================================");
        System.out.println("         Perlita becomes student ");
        System.out.println("====================================================");

        Student PerlitaAlsStudent = userService.promoteToStudent(
                PerlitaAlsUser,
                102,
                "I am a motivated student who is really open to learn new stuff",
                "Netwerk - Verbinding ",
                "Bachelor",
                2027,
                "THomas-Hogeshool",
                new HashSet<>(Arrays.asList("Phython", "Angular", "SQL")
                ));




        //userService.deleteUser(userMikeToSave);

        //userService.deleteUser(PerlitaAlsStudent);
        studnetService.deleteStudent(PerlitaAlsStudent);
        System.out.println(userService.getAllUsers());

        System.out.println(studnetService.getAllStudents());
       // System.out.println(userImplement.getAllUsers());


    }
}