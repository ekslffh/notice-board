package com.example.noticeborder.service;

import com.example.noticeborder.dto.PostDto;
import com.example.noticeborder.entity.PostEntity;
import com.example.noticeborder.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private PostRepository postRepository;

    public void save(PostEntity postEntity) {
        postRepository.save(postEntity);
    }

    public List<PostEntity> findAll() {
        return postRepository.findAll();
    }

    public void delete(Long id) {
        postRepository.delete(id);
    }

}
