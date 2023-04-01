package com.midwestoil.bootstrap;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.dto.RoleDTO;
import com.midwestoil.dto.UserDTO;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.enums.Gender;
import com.midwestoil.enums.State;
import com.midwestoil.service.CompanyService;
import com.midwestoil.service.RoleService;
import com.midwestoil.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;
    CompanyService companyService;

    public DataGenerator(RoleService roleService, UserService userService, CompanyService companyService) {
        this.roleService = roleService;
        this.userService = userService;
        this.companyService = companyService;
    }

    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L, "Admin");
        RoleDTO managerRole = new RoleDTO(2L, "Manager");
        RoleDTO employeeRole = new RoleDTO(3L, "Employee");

        //add data map
        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("John", "Kesy",
                "john@cydeo.com", "Abc1", true, "7459684532", managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@cydeo.com", "Abc2", true, "7459684532", adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@cydeo.com", "123", true, "8567412358", managerRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@cydeo.com", "Abc3", true, "7777775566", employeeRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@cydeo.com", "Abc4", true, "3256987412", managerRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Elizebeth",
                "Loren", "elizebeth@cydeo.com", "Abc4", true, "5306987412", employeeRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria",
                "Ada", "maria@cydeo.com", "Abc4", true, "9996987412", employeeRole, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill",
                "Matt", "bill@cydeo.com", "Abc4", true, "8881239846", employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

        CompanyDTO company1 = new CompanyDTO(1L, "World Fuel", "123-123-4546", "company1@email.com", "1127 New Street CI", State.ILLINOIS, "60176", CompanyType.VENDOR);
        CompanyDTO company2 = new CompanyDTO(2L, "Shell", "123-123-4546", "company1@email.com", "1127 New Street CI", State.ILLINOIS, "60176", CompanyType.CLIENT);
        CompanyDTO company3 = new CompanyDTO(3L, "Moon Fuel", "123-123-4546", "company1@email.com", "1127 New Street CI", State.INDIANA, "60176", CompanyType.VENDOR);
        CompanyDTO company4 = new CompanyDTO(4L, "BP", "123-123-4546", "company1@email.com", "1127 New Street CI", State.ILLINOIS, "60176", CompanyType.CLIENT);
        CompanyDTO company5 = new CompanyDTO(5L, "Mars Fuel", "123-123-4546", "company1@email.com", "1127 New Street CI", State.COLORADO, "60176", CompanyType.VENDOR);
        CompanyDTO company6 = new CompanyDTO(6L, "Walmart", "123-123-4546", "company1@email.com", "1127 New Street CI", State.ILLINOIS, "60176", CompanyType.CLIENT);
        CompanyDTO company7 = new CompanyDTO(7L, "Galaxy Fuel", "123-123-4546", "company1@email.com", "1127 New Street CI", State.PENNSYLVANIA, "60176", CompanyType.VENDOR);
        CompanyDTO company8 = new CompanyDTO(8L, "Costco", "123-123-4546", "company1@email.com", "1127 New Street CI", State.ILLINOIS, "60176", CompanyType.CLIENT);

        companyService.save(company1);
        companyService.save(company2);
        companyService.save(company3);
        companyService.save(company4);
        companyService.save(company5);
        companyService.save(company6);
        companyService.save(company7);
        companyService.save(company8);
    }
}
