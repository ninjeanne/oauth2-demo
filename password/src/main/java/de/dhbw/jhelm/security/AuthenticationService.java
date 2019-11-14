package de.dhbw.jhelm.security;

import de.dhbw.jhelm.domain.User;
import de.dhbw.jhelm.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component("authenticationService")
@Slf4j
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public String getLoggedInUsername() {
        val authentication = SecurityContextHolder.getContext().getAuthentication();
        return this.getUsernameFromOAuth2Token((OAuth2Authentication) authentication);
    }

    private String getUsernameFromOAuth2Token(OAuth2Authentication authentication) {
        return authentication.getOAuth2Request().getRequestParameters().get("username");
    }

    public User getLoggedInUser() {
        if(userRepository.findById(getLoggedInUsername()).isPresent()){
        return userRepository.findById(getLoggedInUsername()).get();
        }
        return User.builder()
                .id("anonyomous")
                .firstName("Ano")
                .lastName("nymous")
                .build();
    }

}
