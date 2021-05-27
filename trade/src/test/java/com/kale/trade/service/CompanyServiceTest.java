package com.kale.trade.service;

import com.kale.trade.dao.CompanyDao;
import com.kale.trade.entity.Company;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



@SpringBootTest
class CompanyServiceTest {

    @Mock
    private CompanyDao mockDao;

    @InjectMocks
    private CompanyService companyService=new CompanyService();

    @Test
    void addCompany() {
        Company c=new Company("TCS");
        when(mockDao.save(any(Company.class))).thenReturn(c);

        Company savedCompany= companyService.addCompany(new Company());
        assertNotNull(savedCompany);
        assertEquals(c.getName(), savedCompany.getName());
    }

    @Test
    void updateCompany() {
        Company c=new Company("TCS");
        when(mockDao.save(any(Company.class))).thenReturn(c);

        Company updatedCompany= companyService.updateCompany(new Company());
        assertNotNull(updatedCompany);
        assertEquals(c.getName(), updatedCompany.getName());

    }

    @Test
    void deleteCompany() {
        doNothing().when(mockDao).deleteById(any(String.class));
        companyService.deleteCompany("C1");
        verify(mockDao,times(1)).deleteById(any(String.class));
    }

    @Test
    void getCompany() {
        when(mockDao.findById(any(String.class))).thenReturn(new Company());
        Company search= companyService.getCompany("C1");
        assertNotNull(search);
    }
}