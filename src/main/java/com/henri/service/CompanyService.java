package com.henri.service;

import com.henri.dao.CompanyDAO;
import com.henri.model.Company;
import com.henri.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyService implements CompanyDAO {

    private final UserService userService; // gebruikt dezelfde USER_LIST

    public CompanyService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Company createCompany(Company company) {
        return (Company) userService.createNewUser(company);
    }
    @Override
    public void updateCompany(Company updatedCompany) {

        for (User user : userService.getAllUsers()) {
            if (user instanceof Company) {
                Company existing = (Company) user;

                if (existing.getCompanyId() == updatedCompany.getCompanyId()) {

                    existing.setFullName(updatedCompany.getFullName());
                    existing.setEmail(updatedCompany.getEmail());
                    existing.setDomainOfActivity(updatedCompany.getDomainOfActivity());
                    existing.setVerified(updatedCompany.isVerified());

                    System.out.println("Company with name " + updatedCompany.getFullName() + " has been updated");
                    return;
                }
            }
        }

        throw new RuntimeException("Company does not exist");
    }

    @Override
    public void deleteCompany(Company company) {
        userService.deleteUser(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return userService.getAllUsers().stream()
                .filter(user -> user instanceof Company)
                .map(user -> (Company) user)
                .collect(Collectors.toList());
    }

    @Override
    public Company findCompanyById(int companyId) {
        return userService.getAllUsers().stream()
                .filter(user -> user instanceof Company)
                .map(user -> (Company) user)
                .filter(c -> c.getCompanyId() == companyId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Company> findCompaniesByDomain(String domain) {
        List<Company> result = new ArrayList<>();

        for (User user : userService.getAllUsers()) {
            if (user instanceof Company) {
                Company c = (Company) user;
                if (domain.equalsIgnoreCase(c.getDomainOfActivity())) {
                    result.add(c);
                }
            }
        }

        return result;
    }

    @Override
    public List<Company> findVerifiedCompanies() {
        List<Company> result = new ArrayList<>();

        for (User user : userService.getAllUsers()) {
            if (user instanceof Company) {
                Company c = (Company) user;
                if (c.isVerified()) {
                    result.add(c);
                }
            }
        }

        return result;
    }
}
