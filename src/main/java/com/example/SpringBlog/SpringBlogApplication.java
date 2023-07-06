package com.example.SpringBlog;

import com.example.SpringBlog.controller.BlogPostController;
import com.example.SpringBlog.model.BlogPost;
import com.example.SpringBlog.repository.BlogPostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBlogApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(BlogPostController blogPostController){
		return (args -> {
			insertTest(blogPostController);
			System.out.println(blogPostController.readBlog());
			System.out.println(blogPostController.readById(Long.valueOf(202)));
		});
	}
	private void insertTest(BlogPostController blogPostController){
		//blogPostController.createBlog(new BlogPost("This Blog","content","Robots"));
		//blogPostController.deleteBlog(Long.valueOf(152));
		//blogPostController.updateBlog(new BlogPost("Updated", "Updated content", "UpC"),Long.valueOf(102));
		}
}


