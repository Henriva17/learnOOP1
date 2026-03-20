package com.henri;

import com.henri.enums.Role;
import com.henri.enums.WorkMode;
import com.henri.model.Company;
import com.henri.model.Student;
import com.henri.model.User;


public class Application {
    public static void main(String[] args) {

        System.out.println("==============================================");
                System.out.println("   INTERNSHIP PLATFORM - TRY TEST");
                System.out.println("==============================================\n");

        // ===== TEST STUDENT =====
        Student student = new Student(
                1,
                "Alice Dupont",
                "alice@example.com",
                "pass123",
                "Brussels",
                Role.STUDENT,
                101,
                "Computer Science",
                "Bachelor",
                2026,
                "ULB"
        );

        System.out.println("===== STUDENT TEST =====");
        System.out.println("Name: " + student.getFullName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Location: " + student.getLocation());
        System.out.println("Role: " + student.getRole());

        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Field: " + student.getFieldOfStudy());
        System.out.println("Education: " + student.getEducationLevel());
        System.out.println("Graduation Year: " + student.getGraduationYear());
        System.out.println("University: " + student.getUniversity());


        // ===== TEST COMPANY =====
        Company company = new Company(
                2,
                "Tech Solutions",
                "hr@techsolutions.com",
                "secret456",
                "Antwerp",
                Role.COMPANY,
                201,
                "Tech Solutions SRL",
                "We build software for businesses",
                "IT"
        );

        System.out.println("\n===== COMPANY TEST =====");
        System.out.println("Name: " + company.getFullName());
        System.out.println("Email: " + company.getEmail());
        System.out.println("Location: " + company.getLocation());
        System.out.println("Role: " + company.getRole());

        System.out.println("Company ID: " + company.getCompanyId());
        System.out.println("Company Name: " + company.getFullName());
        System.out.println("Description: " + company.getDescription());
        System.out.println("Domain: " + company.getDomainOfActivity());
        //Company bij default false we ga dat vervangen
        company.setVerified(true);
        // toString methode geroept
        System.out.println(company.toString());
        System.out.println(student.toString());


        // ===== TEST VALIDATION =====
        System.out.println("\n===== VALIDATION TEST =====");

        try {
            User invalidUser = new User(
                    3,
                    null, // invalid name
                    "badem",
                    "123",
                    "Ghent",
                    Role.STUDENT
            );
        } catch (RuntimeException e) {
            System.out.println("Error caught: " + e.getMessage());
        }
    }
}
