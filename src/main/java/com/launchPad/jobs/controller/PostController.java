package com.launchPad.jobs.controller;

import com.launchPad.jobs.model.Post;
import com.launchPad.jobs.repository.PostRepo;
import com.launchPad.jobs.repository.SearchRepo;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepo repo;

    @Autowired
    SearchRepo srepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/swagger")
    @Hidden  // ← hides this endpoint from Swagger UI
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        System.out.println(">>> DB NAME = " + mongoTemplate.getDb().getName());
        System.out.println(">>> COLLECTION EXISTS = " + mongoTemplate.collectionExists(Post.class));
        System.out.println(">>> COUNT = " + mongoTemplate.count(new org.springframework.data.mongodb.core.query.Query(), Post.class));
        return repo.findAll();
    }
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }
}