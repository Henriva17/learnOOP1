package com.henri.dao;

import com.henri.model.Company;

import java.util.List;

public interface CompanyDAO {
    Company createCompany(Company company);

    void updateCompany(Company company);

    void deleteCompany(Company company);

    List<Company> getAllCompanies();

    Company findCompanyById(int companyId);

    List<Company> findCompaniesByDomain(String domain);

    List<Company> findVerifiedCompanies();

}

