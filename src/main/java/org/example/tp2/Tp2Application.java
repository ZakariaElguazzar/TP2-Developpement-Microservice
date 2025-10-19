package org.example.tp2;

import lombok.AllArgsConstructor;
import org.example.tp2.Entities.Account;
import org.example.tp2.Entities.Customer;
import org.example.tp2.Enums.accountType;
import org.example.tp2.Enums.currencyType;
import org.example.tp2.Repositories.CustomerRepo;
import org.example.tp2.Services.accountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@AllArgsConstructor
public class Tp2Application {
    private accountService accountService;
    private CustomerRepo customerRepo;


    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }
    @Bean
    CommandLineRunner run() {
        return args -> {
            Random random = new Random();

            // Step 1: Create customers
            List<Customer> customers = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Customer customer = new Customer();
                customer.setName("Customer " + i);
                customers.add(customer);
            }
            customerRepo.saveAll(customers);
            System.out.println("✅ 10 customers created successfully!");

            // Step 2: Prepare account types and currencies
            accountType[] accTypes = accountType.values();
            currencyType[] currTypes = currencyType.values();

            // Step 3: Create accounts and assign randomly to customers
            for (int i = 1; i <= 100; i++) {
                Account account = new Account();
                account.setBalance(500 + random.nextDouble() * 9500); // 500–10,000
                account.setAccountType(accTypes[random.nextInt(accTypes.length)]);
                account.setCurrency(currTypes[random.nextInt(currTypes.length)]);
                account.setCreatedAt(new Date()); // set current date/time

                // Assign a random customer
                Customer customer = customers.get(random.nextInt(customers.size()));
                account.setCustomer(customer);

                accountService.createAccount(account);
            }

            System.out.println("✅ 100 accounts created and assigned to customers!");
        };
    }

}
