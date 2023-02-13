package pe.partnerdigital.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.partnerdigital.apigateway.model.Role;
import pe.partnerdigital.apigateway.security.UserPrincipal;
import pe.partnerdigital.apigateway.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("change/{role}")
    public ResponseEntity<?> cambiarRole(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Role role){
        userService.cambiarRole(role, userPrincipal.getUsername());
        return ResponseEntity.ok(true);
    }
}
