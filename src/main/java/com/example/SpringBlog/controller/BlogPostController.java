package com.example.SpringBlog.controller;

import com.example.SpringBlog.model.BlogPost;
import com.example.SpringBlog.service.BlogPostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogPostController {
    @Autowired private BlogPostService blogPostService;

    //save/create
    @PostMapping("/posts")
    @ModelAttribute
    public String createBlog(@Valid @RequestBody BlogPost blogPost){
        blogPostService.createBlog(blogPost);
        return "200-CREATED";
    }
    //read
    @GetMapping("/posts")
    public String readBlog(){
        List<BlogPost> readB = blogPostService.readBlog();
        return readB.toString();
    }
    //read by id
    @GetMapping("/posts/{id}")
    public String readById(@PathVariable("id") Long id){
        return blogPostService.readyById(id).toString();
    }
    //update
    @PutMapping("/posts/{id}")
    public String updateBlog(@RequestBody BlogPost blogPost, @PathVariable("id") Long id){
        blogPostService.updateBlog(blogPost, id);
        return "200-UPDATED";
    }
    //delete
    @DeleteMapping("/posts/{id}")
    public String deleteBlog(@PathVariable("id") Long id){
        blogPostService.deleteBlog(id);
        return "200-Deleted!";
    }
}
