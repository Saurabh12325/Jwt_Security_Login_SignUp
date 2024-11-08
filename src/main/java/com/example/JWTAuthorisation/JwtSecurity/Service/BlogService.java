package com.example.JWTAuthorisation.JwtSecurity.Service;

import com.example.JWTAuthorisation.JwtSecurity.DTO.BlogPostRequest;
import com.example.JWTAuthorisation.JwtSecurity.Repository.BlogRepo;
import com.example.JWTAuthorisation.JwtSecurity.UserEntitiy.blogPostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepo blogRepo;

    public blogPostEntity createPost(BlogPostRequest postRequest, String username) {
        blogPostEntity post = new blogPostEntity();
        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
        post.setTags(postRequest.getTags());
        blogRepo.save(post);

        return post;
    }

    public blogPostEntity updatePost(BlogPostRequest postRequest ,String username){
        Optional<blogPostEntity> checkBlogpOstEXist = blogRepo.findBlogPostEntityByname(username);

        if(checkBlogpOstEXist.isPresent()){
            checkBlogpOstEXist.get().setTitle(postRequest.getTitle());
            checkBlogpOstEXist.get().setDescription(postRequest.getDescription());
            checkBlogpOstEXist.get().setTags(postRequest.getTags());

            blogRepo.save(checkBlogpOstEXist.get());
        }else{
            throw new RuntimeException("blog does not exist");
        }
        return null;
    }


    public Integer deletePost(BlogPostRequest request, String username){
        if(blogRepo.findBlogPostEntityByname(username).isPresent()){
            blogRepo.delete(blogRepo.findBlogPostEntityByname(username).get());
            return 1;
        }
        else{
            return 0;
        }
    }
}
