package com.henri.service;

import com.henri.dao.CompanyDAO;
import com.henri.model.Company;
import com.henri.model.User;

import java.util.ArrayList;
import java.util.List;

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
    public void updateCompany(Company company) {
        userService.updateUser(company);
    }

    @Override
    public void deleteCompany(Company company) {
        userService.deleteUser(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> list = userService.getAllUsers().stream()
                .filter(user -> user instanceof Company)
                .map(user -> (Company) user)
                .toList();
        return list;
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
