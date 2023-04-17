package com.midwestoil.bootstrap;

import com.midwestoil.dto.*;
import com.midwestoil.entity.InvoiceItem;
import com.midwestoil.entity.Product;
import com.midwestoil.enums.*;
import com.midwestoil.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;
    CompanyService companyService;
    ProjectService projectService;
    TaskService taskService;
    ProductService productService;
    InvoiceItemService invoiceItemService;
    InvoiceService invoiceService;

    public DataGenerator(RoleService roleService, UserService userService, CompanyService companyService, ProjectService projectService, TaskService taskService, ProductService productService, InvoiceItemService invoiceItemService, InvoiceService invoiceService) {
        this.roleService = roleService;
        this.userService = userService;
        this.companyService = companyService;
        this.projectService = projectService;
        this.taskService = taskService;
        this.productService = productService;
        this.invoiceItemService = invoiceItemService;
        this.invoiceService = invoiceService;
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
        CompanyDTO company4 = new CompanyDTO(4L, "BP", "123-123-4546", "company1@email.com", "1127 New Street CI", State.ILLINOIS, "60176",CompanyType.CLIENT);
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

        ProjectDTO project1 = new ProjectDTO("Spring MVC","PR001",user1, LocalDate.now(),LocalDate.now().plusDays(25),"Creating Controllers", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM","PR002",user2, LocalDate.now(),LocalDate.now().plusDays(10),"Creating Database", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container","PR003",user1, LocalDate.now(), LocalDate.now().plusDays(32),"Creating Container", Status.IN_PROGRESS);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);

        TaskDTO task1 = new TaskDTO(project1, user8, "Controller", "Request Mapping", Status.IN_PROGRESS, LocalDate.now().minusDays(4));
        TaskDTO task2 = new TaskDTO(project3, user3, "Configuration", "Database Connection", Status.COMPLETE, LocalDate.now().minusDays(12));
        TaskDTO task3 = new TaskDTO(project3, user6, "Mapping", "One-To-Many", Status.COMPLETE, LocalDate.now().minusDays(8));
        TaskDTO task4 = new TaskDTO(project2, user7, "Dependency Injection", "Autowired", Status.IN_PROGRESS, LocalDate.now().minusDays(20));

        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);
        taskService.save(task4);

        ProductDTO product1 = new ProductDTO(1L, "87 Octane", company5 );

        productService.save(product1);

        TaxDTO taxDTO = new TaxDTO(1L, product1, "60176", "Federal 87 Octane", "0.2");



        InvoiceItemDTO invoiceItem1 = new InvoiceItemDTO(1L, product1, 1000, 0.2000, taxDTO);

        invoiceItemService.save(invoiceItem1);


        InvoiceDTO invoice1 = new InvoiceDTO(1L, "378980", LocalDate.of(2023, 04, 07), company5, InvoiceType.PURCHASE, invoiceItemService.findAll());

        invoiceService.save(invoice1);


    }
}
