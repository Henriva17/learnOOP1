package com.henri;

import com.henri.enums.Role;
import com.henri.model.Company;
import com.henri.model.Student;
import com.henri.model.User;
import com.henri.service.CompanyService;
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
            System.out.println("              INTERNSHIP PLATFORM");
            System.out.println("====================================================");

            UserService userService = new UserService();
            StudentService studentService = new StudentService(userService);
            CompanyService companyService = new CompanyService(userService);

            // 1. Create base users
            User aminaUser = new User(1, "Hazak Amina", "amina@gmail.com", Role.USER);
            aminaUser.setLocation("Antwerp");
            aminaUser.setBirthDate(LocalDate.of(2002, 1, 1));

            User perlitaUser = new User(2, "Kazak Perlita", "perlita@gmail.com", Role.USER);
            perlitaUser.setLocation("Ghent");
            perlitaUser.setBirthDate(LocalDate.of(2008, 10, 22));

            User radarUser = new User(3, "Radarwerk SRL", "radar@gmail.com", Role.USER);
            radarUser.setLocation("Charleroi");

            System.out.println("\n=============== Creating Users ================");
            userService.createNewUser(aminaUser);
            userService.createNewUser(perlitaUser);
            userService.createNewUser(radarUser);

            System.out.println(userService.getAllUsers());

            // 2. Promote users
            System.out.println("\n=============================== Promote Amina to Student ====================");
            Student aminaStudent = userService.promoteToStudent(
                    aminaUser,
                    101,
                    "I am a motivated student",
                    "Programming",
                    "Masters",
                    2026,
                    "Odisee-Hogeschool",
                    new HashSet<>(Arrays.asList("Java", "Spring Boot", "SQL"))
            );

            System.out.println("\n=================== Promote Perlita to Student =================");
            Student perlitaStudent = userService.promoteToStudent(
                    perlitaUser,
                    102,
                    "I am a motivated student who is really open to learn new stuff",
                    "Network Engineering",
                    "Bachelor",
                    2027,
                    "Thomas More Hogeschool",
                    new HashSet<>(Arrays.asList("Python", "Angular", "SQL"))
            );

            System.out.println("\n===================== Promote Radarwerk to Company ===================");
            Company radarCompany = userService.promoteToCompany(
                    radarUser,
                    202,
                    "An intermediary linking students and jobs",
                    "HR",
                    "www.radarwerk.be",
                    10
            );

            System.out.println("\n==============All users after promotion ===================");
            System.out.println(userService.getAllUsers());

            // 3. Student tests
            System.out.println("\n=== Student Service Tests ===");
            System.out.println("All students:");
            System.out.println(studentService.getAllStudents());

            System.out.println("Find student by ID 101:");
            System.out.println(studentService.findStudentById(101));

            System.out.println("Find students by skill 'Java':");
            System.out.println(studentService.findStudentsBySkill("Java"));

            // Update student
            perlitaStudent.setGithubLink("https://github.com/perlita");
            perlitaStudent.setLocation("Brussels");
            studentService.updateStudent(perlitaStudent);

            System.out.println("Perlita after update:");
            System.out.println(studentService.findStudentById(102));

            // 4. Company tests
            System.out.println("\n=== Company Service Tests ===");
            System.out.println("All companies:");
            System.out.println(companyService.getAllCompanies());

            System.out.println("Find company by ID 202:");
            System.out.println(companyService.findCompanyById(202));

            System.out.println("Find companies by domain 'HR':");
            System.out.println(companyService.findCompaniesByDomain("HR"));

            // Update company
            radarCompany.setWebsiteLink("https://www.radarwerk.be");
            radarCompany.setDescription("Updated company description");
            companyService.updateCompany(radarCompany);

            System.out.println("Radarwerk after update:");
            System.out.println(companyService.findCompanyById(202));

            // 5. Delete tests
            System.out.println("\n=== Delete Tests ===");
            studentService.deleteStudent(aminaStudent);
            companyService.deleteCompany(radarCompany);

            System.out.println("All users after deletions:");
            System.out.println(userService.getAllUsers());

            System.out.println("All students after deletion:");
            System.out.println(studentService.getAllStudents());

            System.out.println("All companies after deletion:");
            System.out.println(companyService.getAllCompanies());
        }
    }
