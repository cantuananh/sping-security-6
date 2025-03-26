package com.spring_security.model;

import com.spring_security.repository.RoleRepository;
import com.spring_security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner initData(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder encoder) {
        return args -> {
            Role adminRole = roleRepo.findByName("ADMIN")
                    .orElseGet(() -> roleRepo.save(new Role("ADMIN")));
            Role userRole = roleRepo.findByName("USER")
                    .orElseGet(() -> roleRepo.save(new Role("USER")));


            if (userRepo.findByUsername("admin").isEmpty()) {
                User admin = new User("admin", encoder.encode("admin123"), true, Set.of(adminRole));

                userRepo.save(admin);
            }
            if (userRepo.findByUsername("user").isEmpty()) {
                User user = new User("user", encoder.encode("user123"), true, Set.of(userRole));

                userRepo.save(user);
            }
        };
    }
}
