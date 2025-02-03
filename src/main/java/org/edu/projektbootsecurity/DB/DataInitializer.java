package org.edu.projektbootsecurity.DB;

import jakarta.annotation.PostConstruct;
import org.edu.projektbootsecurity.Model.ApplicationsUser;
import org.edu.projektbootsecurity.Repository.ApplicationsUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component //Anger att DataInitializer är en komponent som automatiskt skapas och hanteras av Spring.
public class DataInitializer {
    private final ApplicationsUserRepository applicationsUserRepository;
    private final PasswordEncoder passwordEncoder; //Används för att kryptera lösenord innan de sparas.

    public DataInitializer(ApplicationsUserRepository applicationsUserRepository, PasswordEncoder passwordEncoder) {
        this.applicationsUserRepository = applicationsUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //kontruktor

    @PostConstruct
    public void init() { // användarna,
        if (applicationsUserRepository.findByUsername("admin") == null) {
            ApplicationsUser applicationsUser = new ApplicationsUser();
            applicationsUser.setUsername("admin");
            applicationsUser.setRole("ADMIN");
            applicationsUser.setPassword(passwordEncoder.encode("password"));
            applicationsUserRepository.save(applicationsUser);
        }

        //Koden kollar om en användaren med användarnamnet admin, user eller manager
        // redan finns i databasen

        if (applicationsUserRepository.findByUsername("user") == null) {
            ApplicationsUser applicationsUser = new ApplicationsUser();
            applicationsUser.setUsername("user");
            applicationsUser.setRole("USER");
            applicationsUser.setPassword(passwordEncoder.encode("password"));
            applicationsUserRepository.save(applicationsUser);
        }

        if (applicationsUserRepository.findByUsername("manager") == null) {
            ApplicationsUser applicationsUser = new ApplicationsUser();
            applicationsUser.setUsername("manager");
            applicationsUser.setRole("MANAGER");
            applicationsUser.setPassword(passwordEncoder.encode("password"));
            applicationsUserRepository.save(applicationsUser);
        }
//        if (applicationsUserRepository.findByUserName("Manager") == null) {
//            ApplicationsUser applicationsUser = new ApplicationsUser();
//            applicationsUser.setUserName("manager");
//            applicationsUser.setRole("MANAGER");
//            applicationsUser.setPassword(passwordEncoder.encode("password"));
//            applicationsUserRepository.save(applicationsUser);
//        }

//        if (applicationsUserRepository.findByUserName("admin") == null) {
//            ApplicationsUser applicationsUser = new ApplicationsUser();
//            applicationsUser.setUserName("admin");
//            applicationsUser.setRole("ADMIN");
//
//            applicationsUser.setPassword(passwordEncoder.encode("password"));
//            applicationsUserRepository.save(applicationsUser);
//        }
//
//        if (applicationsUserRepository.findByUserName("user") == null) {
//            ApplicationsUser applicationsUser = new ApplicationsUser();
//            applicationsUser.setUserName("user");
//            applicationsUser.setRole("USER");
//            applicationsUser.setPassword(passwordEncoder.encode("password"));
//            applicationsUserRepository.save(applicationsUser);
//
//        }
    }
}
