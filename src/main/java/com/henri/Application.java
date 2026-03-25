package com.henri;

import com.henri.enums.*;
import com.henri.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Application {

    public static void main(String[] args) {

        System.out.println("====================================================");
        System.out.println("         INTERNSHIP PLATFORM ");
        System.out.println("====================================================");

        // Lijst met ALLE gebruikers (User, Student, Company)
        List<User> registeredUsers = new ArrayList<>();

        // Map met userId als key → snelle toegang tot gebruikers
        Map<Long, User> userMap = new HashMap<>();

        // Lijst enkel voor studenten
        List<Student> students = new ArrayList<>();

        // Lijst enkel voor bedrijven
        List<Company> companies = new ArrayList<>();
        // Lijst enkel voor Application
        List<JobApplication> applications = new ArrayList<>();

        // ====================================================
        // 1. USERS REGISTER ON THE PLATFORM
        // ====================================================

        // Alice registreert zich als gewone gebruiker
        User alice = new User(
                1,
                "Alice Dupont",
                "alice@example.com",
                "pass123",
                "Brussels",
                Role.USER
        );

        // Extra info toevoegen
        alice.setLinkedinLinkPage("https://linkedin.com/in/alice-dupont");

        // Toevoegen aan lijst (voor overzicht)
        registeredUsers.add(alice);

        // Toevoegen aan map (voor snelle opzoeking via ID)
        userMap.put(alice.getUserId(), alice);

        // Perlita registreert zich
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
        userMap.put(perlita.getUserId(), perlita);

        // Tech Solutions registreert eerst als gewone user
        User techSolutionsAccount = new User(
                3,
                "Tech Solutions Account",
                "hr@techsolutions.com",
                "secret456",
                "Antwerp",
                Role.USER
        );

        registeredUsers.add(techSolutionsAccount);
        userMap.put(techSolutionsAccount.getUserId(), techSolutionsAccount);

        // Radarwerk registreert
        User radarwerk = new User(
                4,
                "Radarwerk SRL",
                "radarwerk@be.com",
                "radar123",
                "Gent",
                Role.USER
        );

        registeredUsers.add(radarwerk);
        userMap.put(radarwerk.getUserId(), radarwerk);

        System.out.println("\n--------------- REGISTERED USERS ---------------");

        // We lopen door alle waarden van de map (dus alle users)
        // Dit is een alternatief voor de lijst
        for (User user : userMap.values()) {
            System.out.println(user);
        }

        // ====================================================
        // 2. ALICE BECOMES A STUDENT
        // ====================================================
        System.out.println("\n--------------- ALICE WORDT STUDENT ---------------");

        // We maken een NIEUW Student object met Alice haar gegevens
        alice = new Student(
                (int) alice.getUserId(),
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

        // Casting: alice is nu eigenlijk een Student object
        // maar de variabele is van type User → daarom casten we
        Student aliceProfile = (Student) alice;

        // Student-specifieke info instellen
        aliceProfile.setBio("Passionate student looking for a software engineering internship.");
        aliceProfile.setWorkMode(WorkMode.HYBRID);
        aliceProfile.setGithubLink("https://github.com/alicedupont");
        aliceProfile.setPortfolioLink("https://alicedupont.dev");
        aliceProfile.setCvFilePath("/cv/alice-dupont-cv.pdf");

        // Skills toevoegen
        aliceProfile.setSkills(new HashSet<>(Arrays.asList("Java", "Spring Boot", "SQL")));
        aliceProfile.addSkill("Git");

        // Toevoegen aan studentenlijst
        students.add(aliceProfile);

        // Oude User vervangen door nieuwe Student in lijst
        replaceUserById(registeredUsers, alice);

        // Ook map updaten!
        userMap.put(alice.getUserId(), alice);

        // Print Alice (Student versie)
        System.out.println(alice);

        // ====================================================
        // 3.  PERLITA BECOMES A STUDENT
        // ====================================================
        System.out.println("\n--------------- PERLITA WORDT STUDENT ---------------");

        perlita = new Student(
                (int) perlita.getUserId(),
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

        // Casting nodig om Student-methodes te gebruiken
        Student perlitaProfileStudent = (Student) perlita;

        perlitaProfileStudent.setBio("Interested in data, digital transformation, and internship opportunities.");
        perlitaProfileStudent.setWorkMode(WorkMode.REMOTE);
        perlitaProfileStudent.setGithubLink("https://github.com/perlitaz");
        perlitaProfileStudent.setPortfolioLink("https://portfolio-perlita.dev");
        perlitaProfileStudent.setCvFilePath("/cv/perlita-zuch-cv.pdf");
        perlitaProfileStudent.setSkills(new HashSet<>(Arrays.asList("Java", "Excel")));
        perlitaProfileStudent.addSkill("Power BI");

        students.add(perlitaProfileStudent);

        // Update in lijst en map
        replaceUserById(registeredUsers, perlita);
        userMap.put(perlita.getUserId(), perlita);

        System.out.println(perlita);

        // ====================================================
        // 4. TECH SOLUTIONS ACCOUNT BECOMES A COMPANY
        // ====================================================
        System.out.println("\n--------------- TECH SOLUTIONS WORDT COMPANY ---------------");

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

        replaceUserById(registeredUsers, techSolutionsAccount);
        userMap.put(techSolutionsAccount.getUserId(), techSolutionsAccount);

        System.out.println(techSolutionsAccount);

        // ====================================================
        // 5. RADARWERK BECOMES A COMPANY
        // ====================================================
        System.out.println("\n--------------- RADARWERK WORDT COMPANY ---------------");

        radarwerk = new Company(
                (int) radarwerk.getUserId(),
                radarwerk.getFullName(),
                radarwerk.getEmail(),
                radarwerk.getPassword(),
                radarwerk.getLocation(),
                202,
                "we unite young student with student jobs",
                "HR"
        );

        Company radarwerkProfile = (Company) radarwerk;

        radarwerkProfile.setVerified(true);
        radarwerkProfile.setWebsiteLink("https://radarwerk.be");
        radarwerkProfile.setContactPersonName("Erki");
        radarwerkProfile.setCompanySize(70);

        companies.add(radarwerkProfile);

        replaceUserById(registeredUsers, radarwerk);
        userMap.put(radarwerk.getUserId(), radarwerk);

        System.out.println(radarwerk);

        // ====================================================
        //  JobPosting From radarwerkRadarwerk
        // ====================================================


        JobPosting javaInternship = new JobPosting(
                301,
                radarwerkProfile,
                "Java Internship",
                "Works with backend, OOP and API's",
                JobType.INTERNSHIP,
                WorkMode.HYBRID,
                "Antwerpen",
                JobPostingStatus.OPEN,
                "Bachelor",
                LocalDate.now()

        );
        javaInternship.setRequiredSkills(new HashSet<>(Arrays.asList("Java", "SQL")));



        System.out.println("\n--------------- APPLICATION ---------------");
        JobApplication aliceApplication = new JobApplication(
                401,
                aliceProfile,
                javaInternship,
                "I am highly motivated for this internship offers "
        );
        applications.add(aliceApplication);

        JobApplication perlitaApplication = new JobApplication(
                402,
                perlitaProfileStudent,
                javaInternship,
                "I am highly motivated for this internship offers "
        );
        applications.add(perlitaApplication);

        // ====================================================
        //  PRINT Various List
        // ====================================================

        System.out.println("\n--------------- STUDENT ---------------");

        // Enkel studenten tonen
        for (Student student : students) {
            System.out.println(
                    student.getFullName() + " | " +
                            student.getUniversity() + " | " +
                            student.getFieldOfStudy() + " | " +
                            student.getEducationLevel()
            );
        }

        System.out.println("\n--------------- COMPANY ---------------");

        // Enkel bedrijven tonen
        for (Company company : companies) {
            System.out.println(
                    company.getFullName() + " | " +
                            company.getDomainOfActivity() + " | " +
                            company.getDescription() + " | " +
                            company.getContactPersonName()
            );
        }
        System.out.println("\n--------------- APPLICATION ---------------");
        // Enkel voor Applications
        for(JobApplication apps: applications){
            System.out.println(apps);
        }

        // ====================================================
        // VALIDATION TESTS
        // ====================================================
        System.out.println("\n--------------- VALIDATIE TEST ---------------");

        try {
            // Fout: naam null en email ongeldig
            User invalidUser = new User(
                    5,
                    null,
                    "badmail",
                    "123",
                    "Ghent",
                    Role.USER
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Fout gedetecteerd: " + e.getMessage());
        }

        System.out.println("\n====================================================");
        System.out.println("        EINDE PLATFORM");
        System.out.println("====================================================");
    }

    // Methode om een gebruiker in de lijst te vervangen op basis van ID
    private static void replaceUserById(List<User> users, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == updatedUser.getUserId()) {
                users.set(i, updatedUser); // vervang oude user door nieuwe (Student/Company)
                return;
            }
        }
    }
}