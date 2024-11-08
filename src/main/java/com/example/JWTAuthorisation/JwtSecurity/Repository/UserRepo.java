package com.example.JWTAuthorisation.JwtSecurity.Repository;

import com.example.JWTAuthorisation.JwtSecurity.UserEntitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}


