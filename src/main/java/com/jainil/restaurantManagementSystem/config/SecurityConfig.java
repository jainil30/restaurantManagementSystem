package com.jainil.restaurantManagementSystem.config;


import com.jainil.restaurantManagementSystem.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    RestaurantDetailService restaurantDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        System.out.println("entered filterchain ");
        httpSecurity
                .csrf(t->t.disable())
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers("/admin/**").hasRole("ADMIN")
                            .requestMatchers("/restaurant/**").hasRole("RESTAURANT")
                            .requestMatchers("/login").permitAll()
                            .requestMatchers("/register").permitAll()
                            .anyRequest().authenticated();

                }).formLogin(httpSecurityFormLoginConfigurer -> {
                    System.out.println("entered formLogin ");

                    httpSecurityFormLoginConfigurer.loginPage("/login").loginProcessingUrl("/doLogin").successHandler((request, response, authentication) -> {
                        System.out.println("Entered onSuccess Handler");
                        System.out.println(request.getParameter("username"));
                        request.getSession().setAttribute("email", request.getParameter("username"));
                        System.out.println("It worked");
                        for (GrantedAuthority authority : authentication.getAuthorities()) {
                            if (authority.getAuthority().equals(Role.ROLE_ADMIN.toString())) {
                                response.sendRedirect("/admin/adminDashboard");
                                return;
                            } else if (authority.getAuthority().equals(Role.ROLE_RESTAURANT.toString())) {
                                response.sendRedirect("/restaurant/restaurantDashboard");
                                return;
                            }
                        }
                    }).failureUrl("/login?error=true");
                });

        httpSecurity.authenticationProvider(authProvider());

        return httpSecurity.build();
    }
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(restaurantDetailService);

        return authenticationProvider;
    }


}
