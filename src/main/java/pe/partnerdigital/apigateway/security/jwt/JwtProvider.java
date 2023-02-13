package pe.partnerdigital.apigateway.security.jwt;

import org.springframework.security.core.Authentication;
import pe.partnerdigital.apigateway.model.User;
import pe.partnerdigital.apigateway.security.UserPrincipal;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {

    String generateToken(UserPrincipal auth);

    String generateToken(User user);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
