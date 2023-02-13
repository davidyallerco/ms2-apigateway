package pe.partnerdigital.apigateway.service;

import pe.partnerdigital.apigateway.model.Role;
import pe.partnerdigital.apigateway.model.User;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserService {
    User guardarUsuario(User user);

    Optional<User> buscarPorUsuario(String username);

    @Transactional
    void cambiarRole(Role nuevoRol, String username);
}
