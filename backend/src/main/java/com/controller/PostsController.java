/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

/**
 *
 * @author Kone Adama
 */
import java.util.List;
import java.util.Optional;
import com.model.Post;
import com.model.PostRequest;
import com.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PostsController {

    private final PostService postService;

    @Autowired
    public PostsController(PostService postService) {
        this.postService = postService;
    }

  
          @GetMapping("/posts")
    public List<Post> list(@RequestParam(required = false) String title) {
        if (StringUtils.isEmpty(title)) {
            return postService.getAll();
        }
        return postService.findByTitle(title);
    }

    @PostMapping("/posts")
    public Integer save(@RequestBody PostRequest request) {
        return postService.save(request);
    }




    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> post(@PathVariable int id) {
        Optional<Post> post = postService.findById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound()
                                                  .build());
    }

      @PutMapping("/posts/{id}/publish")
    public void publishUnpublish(@PathVariable int id, @RequestBody PostRequest request) {
        postService.changePublishedFlag(id, request);
    }

    @PutMapping(value="/posts/{id}")
    public void update(@PathVariable int id, @RequestBody PostRequest request) {
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()) {
            postService.update(id, request);
        } else {
            postService.save(request);
        }
    }

    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable int id) {
        postService.delete(id);
    }
}