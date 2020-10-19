package com.socialnetwork.controller;

import com.socialnetwork.models.Post;
import com.socialnetwork.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    List<Post> getAllPost(){
        return postRepository.findAll();
    }

    @GetMapping("/post/{id}")
    Post getPostDetail(@PathVariable Long id){
        Post postDetail = postRepository.findById(id).orElse(null);
        return postDetail;
    }

    @PostMapping("/newpost")
    ResponseEntity<Post> createPost(@RequestBody Post post) throws URISyntaxException {
        Post result = postRepository.save(post);
        return ResponseEntity.created(new URI("/api/post" + result.getId())).body(result);
    }

    @PutMapping("/post/{id}")
    ResponseEntity<?> updatePost (@RequestBody Post post) throws URISyntaxException {
        Post result = postRepository.save(post);
        return ResponseEntity.created(new URI("/api/post" + result.getId())).body(result);
    }

    @DeleteMapping("/post/{id}")
    ResponseEntity<?> deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
