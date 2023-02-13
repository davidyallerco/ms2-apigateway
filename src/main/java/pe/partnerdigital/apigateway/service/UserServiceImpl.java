package pe.partnerdigital.apigateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.partnerdigital.apigateway.model.Role;
import pe.partnerdigital.apigateway.model.User;
import pe.partnerdigital.apigateway.repository.UserRepository;
import pe.partnerdigital.apigateway.security.jwt.JwtProvider;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User guardarUsuario(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword())); //tenemos el password encriptado
        user.setRole(Role.USER); //el tipo de rol es user
        user.setFechaCreacion(LocalDateTime.now());
        User userCreated = userRepository.save(user);

        String jwt = jwtProvider.generateToken(userCreated);
        userCreated.setToken(jwt);

        return userCreated;
    }
    @Override
    public Optional<User> buscarPorUsuario(String username){
        return userRepository.findByUsername(username);
    }

    //actualizar el rol de usuario
    @Transactional
    @Override
    public void cambiarRole(Role nuevoRol, String username){
        userRepository.updateUserRole(username,nuevoRol );
    }
}
