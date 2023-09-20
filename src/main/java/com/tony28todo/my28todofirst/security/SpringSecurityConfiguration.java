package com.tony28todo.my28todofirst.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    //LDAP or DataBase

//    InMemoryUserDetailsManager
//    InMemoryUserDetailsManager(UserDetails... users)

        @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
            Function<String, String> passwordEncoder
                    = input -> passwordEncoder().encode(input);

            UserDetails userDetails = User.builder()
                    .passwordEncoder(passwordEncoder)
                    .username("tonyVladi")
                    .password("dummy")
                    .roles("USER","ADMIN")
                    .build();

                    return new InMemoryUserDetailsManager(userDetails);
        }

        @Bean
    public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
}
