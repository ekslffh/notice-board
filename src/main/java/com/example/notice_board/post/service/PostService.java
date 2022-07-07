package com.example.notice_board.post.service;

import com.example.notice_board.post.dto.PostDto;
import com.example.notice_board.post.entity.PostEntity;
import com.example.notice_board.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void save(PostDto postDto) {
        postRepository.save(dtoToEntity(postDto));
    }

    public PostDto findById(Long id) {
        Optional<PostEntity> optionalEntity = postRepository.findById(id);
        if (optionalEntity.isPresent()) {
            return entityToDto(optionalEntity.get());
        }
        else return null;
    }

    public List<PostEntity> findAll() { return postRepository.findAll();}

    public void delete(Long id) {
        postRepository.delete(id);
    }

    public void deleteAll() { postRepository.deleteAll(); }

    public PostDto entityToDto(PostEntity entity) {
        return PostDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public PostEntity dtoToEntity(PostDto dto) {
        PostEntity entity = PostEntity.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        if (dto.getId() != null) entity.setId(dto.getId());

        return entity;
    }

}
