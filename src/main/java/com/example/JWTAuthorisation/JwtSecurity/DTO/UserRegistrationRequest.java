package com.example.JWTAuthorisation.JwtSecurity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//dto ka use hain data ko client aur server ke beech me transfer karne ke liye
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserRegistrationRequest {

private String username;
private String email;
private String password;
private String bio;

}
