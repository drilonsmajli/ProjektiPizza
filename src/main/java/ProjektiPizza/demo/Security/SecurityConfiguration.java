package ProjektiPizza.demo.Security;

import ProjektiPizza.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    UserRepository userRepository;

    @Override
    protected void configure(
            AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(username -> {
                    UserDetails userDetails = userRepository.getOne(username);
                    if (userDetails != null) {
                        return userDetails;
                    }
                    throw new UsernameNotFoundException("User '" + username + "' not found.");
                });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();//?
        http.authorizeRequests().
                antMatchers("/payment/**").hasRole("USER")
                .antMatchers("/pizza/**").hasRole("USER")
                .and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}