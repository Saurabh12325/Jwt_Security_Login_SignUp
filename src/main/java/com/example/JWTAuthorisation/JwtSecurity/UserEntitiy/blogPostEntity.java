package com.example.JWTAuthorisation.JwtSecurity.UserEntitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class blogPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String title;
    private String description;
    private String image;
    private LocalDateTime createdAt;
    private String tags;

}

// @ManyToOne
// @JoinTable(name = "users")
//  private User username;

