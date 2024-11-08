package com.example.JWTAuthorisation.JwtSecurity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ye post create and update request ke liye data ko capture karta hai
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostRequest {
    private String title;
    private String description;
    private String tags;
}
