package pe.partnerdigital.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.partnerdigital.apigateway.model.Role;
import pe.partnerdigital.apigateway.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    //findBy + nombreCampo
    Optional<User> findByUsername(String username);

    //actualiza asignadole un rol determinado a un usuario
    @Modifying //Porque modificara la base de datos
    @Query("update User set role=:role where username=:username")
    void updateUserRole(@Param("username") String username, @Param("role")Role role);
}
