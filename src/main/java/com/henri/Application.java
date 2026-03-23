package com.henri;

import com.henri.enums.Role;
import com.henri.enums.WorkMode;
import com.henri.model.Company;
import com.henri.model.Student;
import com.henri.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        System.out.println("====================================================");
        System.out.println("         INTERNSHIP PLATFORM ");
        System.out.println("====================================================");

        List<User> registeredUsers = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Company> companies = new ArrayList<>();

        // ====================================================
        // 1. USERS REGISTER ON THE PLATFORM
        // ====================================================
        User alice = new User(
                1,
                "Alice Dupont",
                "alice@example.com",
                "pass123",
                "Brussels",
                Role.USER
        );
        alice.setLinkedinLinkPage("https://linkedin.com/in/alice-dupont");
        registeredUsers.add(alice);

        User perlita = new User(
                2,
                "Perlita Zuch",
                "perlita@example.com",
                "pass456",
                "Brussels",
                Role.USER
        );
        perlita.setProfilePicture("/images/perlita.png");
        registeredUsers.add(perlita);

        User techSolutionsAccount = new User(
                3,
                "Tech Solutions Account",
                "hr@techsolutions.com",
                "secret456",
                "Antwerp",
                Role.USER
        );
        registeredUsers.add(techSolutionsAccount);

        User radarwerk = new User(
                4,
                "Radarwerk SRL",
                "radarwerk@be.com",
                "radar123",
                "Gent",
                Role.USER
        );
        registeredUsers.add(radarwerk);

        System.out.println("\n--------------- REGISTERED USERS ---------------");
        for (User user : registeredUsers) {
            System.out.println(user);
        }

        // ====================================================
        // 2. ALICE BECOMES A STUDENT
        // ====================================================
        System.out.println("\n--------------- ALICE BECOMES STUDENT ---------------");

        alice = new Student(
                (int)alice.getUserId(),
                alice.getFullName(),
                alice.getEmail(),
                alice.getPassword(),
                alice.getLocation(),
                101,
                "Computer Science",
                "Bachelor",
                2026,
                "ULB"
        );

        Student aliceProfile = (Student) alice;
        aliceProfile.setBio("Passionate student looking for a software engineering internship.");
        aliceProfile.setWorkMode(WorkMode.HYBRID);
        aliceProfile.setGithubLink("https://github.com/alicedupont");
        aliceProfile.setPortfolioLink("https://alicedupont.dev");
        aliceProfile.setCvFilePath("/cv/alice-dupont-cv.pdf");
        aliceProfile.setSkills(new ArrayList<>(Arrays.asList("Java", "Spring Boot", "SQL")));
        aliceProfile.addSkill("Git");

        students.add(aliceProfile);
        //students.add((Student) alice);    since alice is already a student

        // update registeredUsers list with the transformed account
        replaceUserById(registeredUsers, alice);   // replaceUserById update olduser with new users Attributes

        System.out.println(alice);

        // ====================================================
        // 2i. PERLITA BECOMES A STUDENT
        // ====================================================
        System.out.println("\n--------------- PERLITA BECOMES STUDENT ---------------");

        perlita = new Student(
                (int)perlita.getUserId(),
                perlita.getFullName(),
                perlita.getEmail(),
                perlita.getPassword(),
                perlita.getLocation(),
                102,
                "Business Informatics",
                "Master",
                2027,
                "VUB"
        );

        Student perlitaProfileStudent = (Student) perlita;      // To acces Students specific methods
        perlitaProfileStudent.setBio("Interested in data, digital transformation, and internship opportunities.");
        perlitaProfileStudent.setWorkMode(WorkMode.REMOTE);
        perlitaProfileStudent.setGithubLink("https://github.com/perlitaz");
        perlitaProfileStudent.setPortfolioLink("https://portfolio-perlita.dev");
        perlitaProfileStudent.setCvFilePath("/cv/perlita-zuch-cv.pdf");
        perlitaProfileStudent.setSkills(new ArrayList<>(Arrays.asList("Java", "Excel")));
        perlitaProfileStudent.addSkill("Power BI");

        students.add(perlitaProfileStudent);
        //students.add((Student) perlita); // since Perlita is already a student


        // update registeredUsers list with the transformed account
        replaceUserById(registeredUsers, perlita);

        System.out.println(perlita);

        // ====================================================
        // 3. TECH SOLUTIONS ACCOUNT BECOMES A COMPANY
        // ====================================================
        System.out.println("\n--------------- TECH SOLUTIONS BECOMES COMPANY ---------------");

        techSolutionsAccount = new Company(
                (int) techSolutionsAccount.getUserId(),
                techSolutionsAccount.getFullName(),
                techSolutionsAccount.getEmail(),
                techSolutionsAccount.getPassword(),
                techSolutionsAccount.getLocation(),
                201,
                "We build software solutions for modern businesses.",
                "IT"
        );

        Company techSolutionsProfile = (Company) techSolutionsAccount;
        techSolutionsProfile.setWebsiteLink("https://www.techsolutions.com");
        techSolutionsProfile.setCompanySize(150);
        techSolutionsProfile.setContactPersonName("Sophie Janssens");
        techSolutionsProfile.setVerified(true);

        companies.add(techSolutionsProfile);
        //companies.add((Company) techSolutionsAccount); since techSol is already a company

        // update registeredUsers list with the transformed account
        replaceUserById(registeredUsers, techSolutionsAccount);

        System.out.println(techSolutionsAccount);

        // ====================================================
        // 3. TECH SOLUTIONS ACCOUNT BECOMES A COMPANY
        // ====================================================
        System.out.println("\n--------------- Radarwerk SRL BECOMES COMPANY ---------------");

        radarwerk = new Company(
                (int)radarwerk.getUserId(),
                radarwerk.getFullName(),
                radarwerk.getEmail(),
                radarwerk.getPassword(),
                radarwerk.getLocation(),
                202,
                "we unite young student with student jobs",
                "HR"
        );
        Company radarwerkProfile= (Company) radarwerk;
        radarwerkProfile.setVerified(true);
        radarwerkProfile.setWebsiteLink("https://radarwerk.be");
        radarwerkProfile.setContactPersonName("Erki");
        radarwerkProfile.setCompanySize(70);

        companies.add(radarwerkProfile);
        //companies.add((Company) radarwerk);     since radarwerk is already a company

        replaceUserById(registeredUsers, radarwerk);

        System.out.println(radarwerk);



        System.out.println("\n--------------- LIST OF STUDENTS ---------------");
        for (Student student : students) {
            System.out.println(
                    student.getFullName() + " | " +
                            student.getUniversity() + " | " +
                            student.getFieldOfStudy() + " | " +
                            student.getEducationLevel()
            );
        }
        System.out.println("\n--------------- LIST OF COMPANIES ---------------");
        for (Company company : companies) {
            System.out.println(
                    company.getFullName() + " | " +
                            company.getDomainOfActivity() + " | " +
                            company.getDescription() + " | " +
                            company.getContactPersonName()
            );
        }

        // ====================================================
        // 6. VALIDATION TESTS
        // ====================================================
        System.out.println("\n--------------- VALIDATION TESTS ---------------");

        try {
            User invalidUser = new User(
                    5,
                    null,
                    "badmail",
                    "123",
                    "Ghent",
                    Role.USER
            );
            System.out.println(invalidUser);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error caught: " + e.getMessage());
        }

        try {
            Student invalidStudent = new Student(
                    6,
                    "Invalid Student",
                    "student@example.com",
                    "pass123",
                    "Namur",
                    0,
                    "",
                    "Bachelor",
                    2010,
                    ""
            );
            System.out.println(invalidStudent);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error caught: " + e.getMessage());
        }

        System.out.println("\n====================================================");
        System.out.println("        END OF INTERNSHIP PLATFORM");
        System.out.println("====================================================");
    }

    private static void replaceUserById(List<User> users, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == updatedUser.getUserId()) {
                users.set(i, updatedUser);
                return;
            }
        }
    }
}