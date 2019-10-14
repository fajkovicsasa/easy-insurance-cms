package hr.digitalnival.insurance.config;

import hr.digitalnival.insurance.service.AuthenticationUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private AuthenticationUserDetailsService authenticationUserDetailsService;


    public WebSecurityConfig(AuthenticationUserDetailsService authenticationUserDetailsService) {
        this.authenticationUserDetailsService = authenticationUserDetailsService;
    }

    @Bean
    AuthenticationProvider authProvider() {
        //TODO implement BCrypt
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(authenticationUserDetailsService);

        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //TODO separate by roles /api, /h2-console
        http.authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated() ///all other urls can be access by any authenticated role
                .and().formLogin()
                .and().headers().frameOptions().sameOrigin()
                .and().csrf().disable(); //allow use of frame to same origin urls
    }
}