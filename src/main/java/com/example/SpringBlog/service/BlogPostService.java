package com.example.SpringBlog.service;

import com.example.SpringBlog.model.BlogPost;
import com.example.SpringBlog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BlogPostService {
    @Autowired private BlogPostRepository blogPostRepository;

    //save/create
    public BlogPost createBlog(BlogPost blogPost){
        return blogPostRepository.save(blogPost);
    }
    //read
    public List<BlogPost> readBlog(){
         return (List<BlogPost>) blogPostRepository.findAll();
    }
    //read by id
    public Optional<BlogPost> readyById(Long id){
        return blogPostRepository.findById(id);
    }
    //update
    public BlogPost updateBlog(BlogPost blogPost, Long id){
        BlogPost blogDB = blogPostRepository.findById(id).get();
        if (Objects.nonNull(blogPost.getTitle()) && !"".equalsIgnoreCase(blogPost.getTitle())){
            blogDB.setTitle(blogPost.getTitle());
        }
        if (Objects.nonNull(blogPost.getContent()) && !"".equalsIgnoreCase(blogPost.getContent())){
            blogDB.setContent(blogPost.getContent());
        }
        if (Objects.nonNull(blogPost.getAuthor()) && !"".equalsIgnoreCase(blogPost.getAuthor())){
            blogDB.setAuthor(blogPost.getAuthor());
        }
        return blogPostRepository.save(blogDB);
    }
    //delete
    public void deleteBlog(Long id){
        blogPostRepository.deleteById(id);
    }
}
