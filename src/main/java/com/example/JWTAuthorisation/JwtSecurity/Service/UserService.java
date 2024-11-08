package com.example.JWTAuthorisation.JwtSecurity.Service;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.example.JWTAuthorisation.JwtSecurity.Controller.AuthenticationResponse;
import com.example.JWTAuthorisation.JwtSecurity.DTO.UserRegistrationRequest;
import com.example.JWTAuthorisation.JwtSecurity.Repository.UserRepo;
import com.example.JWTAuthorisation.JwtSecurity.Security.JwtUtil;
import com.example.JWTAuthorisation.JwtSecurity.UserEntitiy.Role;
import com.example.JWTAuthorisation.JwtSecurity.UserEntitiy.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

//user registration and profile management ke
@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
   private  final JwtUtil jwtUtil;
   private final AuthenticationManager authenticationManager;

    public AuthenticationResponse userRegistration(UserRegistrationRequest request){
//
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepo.save(user);
        var jwtToken = jwtUtil.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
   }



    public AuthenticationResponse loginUser(UserRegistrationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword())
        );
        var user = userRepo.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtUtil.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
