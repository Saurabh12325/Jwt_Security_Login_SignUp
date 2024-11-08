package com.example.JWTAuthorisation.JwtSecurity.Repository;

import com.example.JWTAuthorisation.JwtSecurity.UserEntitiy.User;
import com.example.JWTAuthorisation.JwtSecurity.UserEntitiy.blogPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.util.Optional;
@EnableJpaRepositories
public interface BlogRepo extends JpaRepository<blogPostEntity, Long> {
    Optional<blogPostEntity> findBlogPostEntityByname(String username);
}

