package pe.partnerdigital.apigateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.partnerdigital.apigateway.model.User;
import pe.partnerdigital.apigateway.service.UserService;
import pe.partnerdigital.apigateway.utils.SecurityUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService { //implementar UserDetailsService que es de spring

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.buscarPorUsuario(username)
                .orElseThrow(()->new UsernameNotFoundException("El usuario no fue encontrado:" + username));
//        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name())); //java 9
        Set<GrantedAuthority> authorities = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(SecurityUtils.convertToAuthority(user.getRole().name()))));
        return UserPrincipal.builder()
                .user(user)
                .id(user.getId())
                .username(username)
                .password(user.getPassword())
                .authorities(authorities)
                .build();

    }
}
