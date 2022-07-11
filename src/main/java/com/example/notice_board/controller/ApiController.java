package com.example.notice_board.controller;

import com.example.notice_board.post.dto.PostRequest;
import com.example.notice_board.post.dto.PostResponse;
import com.example.notice_board.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponse> create(@RequestBody PostRequest request) {
        PostResponse response = postService.add(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> findById(@PathVariable Long id) {
        PostResponse response = postService.searchById(id);
        return (response != null) ? ResponseEntity.ok(response) : ResponseEntity.badRequest().header("warn-message", "try with another id").build();
    }

    @GetMapping
    public List<PostResponse> findAll() { return postService.findAll(); }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> update(@PathVariable Long id, @RequestBody PostRequest request) {
        PostResponse response = postService.updateById(id, request);
        return (response != null) ? ResponseEntity.ok(response) : ResponseEntity.badRequest().header("warn-message", "try with another id").build();
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        postService.deleteById(id);
    }

    @DeleteMapping
    public void removeAll() {
        postService.deleteAll();
    }

}
