package pe.partnerdigital.apigateway.service;

import pe.partnerdigital.apigateway.model.User;

public interface AuthenticationService {

    User signInAndReturnJWT(User signInRequest);
}
