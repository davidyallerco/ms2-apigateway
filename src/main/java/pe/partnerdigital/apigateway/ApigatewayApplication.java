package pe.partnerdigital.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ApigatewayApplication {


	public static void main(String[] args) {

		SpringApplication.run(ApigatewayApplication.class, args);
	}
	//metodo para encriptar el password , sera llamado desde UserServiceImpl
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
/*
* web, security, jpa,rest repository,mysql,openFeign (enlazar a otros ms),eureka discovery client, lombok
*agregas manualmente:  JJWT :: Impl (json web token), jjwt-api, jjwt-jackson (es para la serializacion de los obj)
*
* OJO: se recomienda en usuarios admin de mysql poner una clave robusta para evitar problemas de logueo
*
* registrar nuevo usuario :post
* http://localhost:5555/api/authentication/sign-up
* {
    "nombre": "ezer",
     "username": "ezer",
     "password": "12345678"
 }
 *
* loguearse con el user creado : post
* http://localhost:5555/api/authentication/sign-in
*{
     "username": "ezer",
     "password": "12345678"
 }
 *
 *
 *  cambiando de rol, actualizar : put
* http://localhost:5555/api/user/change/ADMIN
* authorization > bearer token: pegas el token
* ...devuelve true el cual quiere decir que se cambio de rol
* */