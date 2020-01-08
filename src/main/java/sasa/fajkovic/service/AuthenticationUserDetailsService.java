package sasa.fajkovic.service;

import sasa.fajkovic.model.User;
import sasa.fajkovic.model.UserPrincipal;
import sasa.fajkovic.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public AuthenticationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(s);
        return new UserPrincipal(user);
    }
}
