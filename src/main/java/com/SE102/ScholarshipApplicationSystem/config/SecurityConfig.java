package com.SE102.ScholarshipApplicationSystem.config;


import com.SE102.ScholarshipApplicationSystem.service.AdminDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AdminDetailService adminDetailService;



    @Autowired
    private JWTAuthFilterAdmin jwtAuthFilterAdmin;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request-> request.requestMatchers("/admin/**", "/scholar/signin", "/scholar/signup",
                                "/admin/signin", "/admin/signup", "/pendingApplication/{pendingId}",
                                "/pendingApplication", "/pending/count", "/scholar", "/scholar/{scholarId}",
                                "/newscholar", "/scholar/count", "/programs/{programId}", "/programs/**",
                                "/waiting/**", "/statusUpdate/{programId}", "/disbursedPrograms", "/disbursed/count",
                                "/updateStatus/{programId_waiting}", "/listProgram", "/programs/count",
                                "/programs/{programId}", "/admin/{adminId}", "/listProgram/{programId_disbursed}",
                                "/singlepost/{pendingId}").permitAll()
                        .requestMatchers("/**").hasAnyAuthority("ADMIN")
                        .requestMatchers("/**").hasAnyAuthority("USER")
                        .requestMatchers("/**").hasAnyAuthority("USER", "ADMIN")
                        .anyRequest().authenticated())
                .sessionManagement(manager->manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilterAdmin, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(adminDetailService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration){
        try {
            return authenticationConfiguration.getAuthenticationManager();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
