package com.example.JWTAuthorisation.JwtSecurity.Controller;

import com.example.JWTAuthorisation.JwtSecurity.DTO.BlogPostRequest;

import com.example.JWTAuthorisation.JwtSecurity.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/Blog")
public class BlogController {

    private final BlogService blogService;

        public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }



        @PostMapping("/create")
        public ResponseEntity<?> createPost(@RequestBody BlogPostRequest request, Principal principal) {
            blogService.createPost(request, principal.getName());
            return ResponseEntity.ok("Post created successfully");
        }

        @PostMapping("/update")
        public ResponseEntity<?> updatePost(@RequestBody BlogPostRequest request, Principal principal) {
            blogService.updatePost(request, principal.getName());
            return ResponseEntity.ok("Post updated successfully");
        }

        @PostMapping("/delete")
        public ResponseEntity<?> deletePost(@RequestBody BlogPostRequest request, Principal principal) {
            blogService.deletePost(request, principal.getName());
            return ResponseEntity.ok("Post deleted successfully");
        }
    }

