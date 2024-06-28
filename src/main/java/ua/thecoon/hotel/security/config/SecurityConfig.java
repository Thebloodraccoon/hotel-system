package ua.thecoon.hotel.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ua.thecoon.hotel.repo.UserRepo;
import ua.thecoon.hotel.security.auth.HotelAuthEntryPoint;
import ua.thecoon.hotel.security.filter.HotelFilter;
import ua.thecoon.hotel.security.service.HotelUserDetailsService;
import ua.thecoon.hotel.security.util.JwtUtil;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private HotelAuthEntryPoint hotelAuthEntryPoint;
    @Autowired
    private JwtUtil jwtUtil;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests( conf ->
                        conf
                                .requestMatchers(antMatcher("/auth/**")).permitAll()
                                .requestMatchers(antMatcher("/admin/**")).hasAuthority("Admin")
                                .anyRequest().authenticated()
                )
                .exceptionHandling(conf ->
                        conf.authenticationEntryPoint(hotelAuthEntryPoint))
                .sessionManagement(conf ->
                        conf.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(hotelFilter(),
                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HotelFilter hotelFilter(){
        return new HotelFilter(userDetailsService(), jwtUtil);
    }

    @Bean
    public HotelUserDetailsService userDetailsService() {
        return new HotelUserDetailsService(userRepo);
    }

    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authenticationProvider);
    }
}
