package de.dhbw.jhelm;

import de.dhbw.jhelm.domain.User;
import de.dhbw.jhelm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class TestData {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        userRepository.save(User.builder()
                .id("maxmuster")
                .lastName("Mustermann")
                .firstName("Max")
                .build());
        userRepository.save(User.builder()
                .id("hansim")
                .lastName("im Glück")
                .firstName("Hans")
                .build());
        userRepository.save(User.builder()
                .id("admin")
                .lastName("Chef")
                .firstName("Der")
                .build());
    }
}
