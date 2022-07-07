package com.example.notice_board.controller;

import com.example.notice_board.post.dto.PostDto;
import com.example.notice_board.post.entity.PostEntity;
import com.example.notice_board.post.service.PostService;
import com.example.notice_board.security.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public void create(@RequestBody PostDto postDto) {
        postService.save(postDto);
        System.out.println(postDto);
    }

    @GetMapping("/{id}")
    public PostDto find(@PathVariable Long id) {
        return postService.findById(id);
    }

    @GetMapping
    public List<PostEntity> findAll() {
        return postService.findAll();
    }

    @PutMapping
    public void update(@RequestBody PostDto postDto) {
        postService.save(postDto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        postService.delete(id);
    }

    @DeleteMapping
    public void removeAll(@RequestBody Account account) {
        if(account.getId().equals("spring") && account.getPassword().equals("1234")) {
            postService.deleteAll();
        }
    }

}
