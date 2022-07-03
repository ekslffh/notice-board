package com.example.noticeborder.controller;

import com.example.noticeborder.entity.PostEntity;
import com.example.noticeborder.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @PostMapping
    public void post(@RequestBody PostEntity postEntity) {
        boardService.save(postEntity);
        System.out.println(postEntity);
    }

    @GetMapping
    public List<PostEntity> findAll() {
        return boardService.findAll();
    }

    @PutMapping
    public void put(@RequestBody PostEntity postEntity) {
        boardService.save(postEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }

}
