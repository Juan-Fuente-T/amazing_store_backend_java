package com.campusdual.amazing_store.config;

import com.campusdual.amazing_store.auth.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
/**
 * Security configuration class for setting up Spring Security.
 * This class defines the security filter chain, authentication manager,
 * password encoder, and user details service.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private JwtAuthenticationFilter jwtAuthFilter;
    /**
     * Configures the security filter chain for HTTP requests.
     *
     * @param http the HttpSecurity object to configure
     * @return a configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/test/public").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    /**
     * Provides the AuthenticationManager bean.
     *
     * @param authConfig the AuthenticationConfiguration object
     * @return an AuthenticationManager instance
     * @throws Exception if an error occurs while retrieving the manager
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
    /**
     * Provides a PasswordEncoder bean using BCrypt hashing.
     *
     * @return a PasswordEncoder instance
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    /**
     * Provides a UserDetailsService bean with in-memory user details.
     *
     * @param passwordEncoder the PasswordEncoder to use for encoding passwords
     * @return a UserDetailsService instance with predefined users
     */
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("admin")
//                .password("{noop}admin123") // {noop} indica que la contraseña no esta encriptada
                .password(passwordEncoder.encode("admin123")) // Contraseña encriptada con BCrypt
                .roles("admin")
                .build();

        UserDetails user2 = User.withUsername("user")
//                .password("{noop}user123")
                .password(passwordEncoder.encode("user123")) // Contraseña encriptada con BCrypt
                .roles("owner")
                .build();

        return new InMemoryUserDetailsManager(user, user2);
    }
}
