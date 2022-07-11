package com.example.notice_board.post.service;

import com.example.notice_board.post.dto.PostRequest;
import com.example.notice_board.post.dto.PostResponse;
import com.example.notice_board.post.entity.PostEntity;
import com.example.notice_board.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository repository;

    public PostResponse add(PostRequest request) {
        PostEntity entity = PostEntity.builder()
                            .title(request.getTitle())
                            .content(request.getContent())
                            .createdAt(LocalDateTime.now())
                            .updatedAt(LocalDateTime.now())
                            .build();
        return PostResponse.entityToResponse(repository.save(entity));
    }

    public PostResponse searchById(Long id) {
        Optional<PostEntity> optionalEntity = repository.findById(id);
        return optionalEntity.map(PostResponse::entityToResponse).orElse(null);
    }

    public PostResponse updateById(Long id, PostRequest request) {
        Optional<PostEntity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            PostEntity entity = optionalEntity.get();
            if (request.getTitle() != null) entity.setTitle(request.getTitle());
            if (request.getContent() != null) entity.setContent(request.getContent());
            entity.setUpdatedAt(LocalDateTime.now());
            return PostResponse.entityToResponse(repository.save(entity));
        }
        else return null;
    }

    public List<PostResponse> findAll() { return repository.findAll().stream().map(PostResponse::entityToResponse).collect(Collectors.toList());}

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() { repository.deleteAll(); }

}
