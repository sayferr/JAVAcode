package com.studeis.tomcat.social_network.security.config;

import com.studeis.tomcat.social_network.security.JWT.JwtAuthFilter;
import com.studeis.tomcat.social_network.security.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))

                .authorizeHttpRequests(auth -> auth
                        // static
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/favicon.ico", "/uploads/**").permitAll()

                        // public pages
                        .requestMatchers("/", "/login", "/register", "/profile",
                                "/edit_profile", "/error", "/post", "/create_post", "/post_view").permitAll()

                        //API private
                        .requestMatchers("/api/users/profile").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/users/profile").authenticated()
                        .requestMatchers("/api/users/edit_profile").authenticated()
                        .requestMatchers("/api/posts/user/").authenticated()
                        .requestMatchers("/api/posts/").authenticated()
                        .requestMatchers("/api/posts/my").authenticated()
                        .requestMatchers("/api/comments/**").authenticated()
                        .requestMatchers("/api/message/**").authenticated()

                        // auth API
                        .requestMatchers("/api/auth/**").permitAll()

                        // posts protected
                        .requestMatchers("/api/posts/**").authenticated()

                        // Role User
                        .requestMatchers("/profile","/api/users/profile").hasRole("USER")

                        //Role admin
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )

                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(new Http403ForbiddenEntryPoint())
                );

        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(CustomUserDetailsService userDetailsService,
                                                       PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
        daoAuthProvider.setUserDetailsService(userDetailsService);
        daoAuthProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(List.of(daoAuthProvider));
    }
}