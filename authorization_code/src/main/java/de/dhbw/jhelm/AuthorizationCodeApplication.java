package de.dhbw.jhelm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class AuthorizationCodeApplication extends WebSecurityConfigurerAdapter {

    /**
     * Get user info for frontend.
     *
     * @param principal The authenticated user.
     * @return The authenticated user.
     */
    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

    /**
     * Require a login for for anything except /, /login.*, /webjars/.* and /error.* .
     *
     * @param http The current security context.
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/webjars/**", "/error**")
                    .permitAll()
                .anyRequest()
                    .authenticated();
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationCodeApplication.class, args);
    }
}
