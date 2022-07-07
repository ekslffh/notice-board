package com.example.notice_board.db;

import com.example.notice_board.post.entity.PostEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryImpl<T extends BasicEntity> implements RepositoryIfs<T> {

    List<T> repository = new ArrayList<>();
    Long id = 0L;

    @Override
    public T save(T entity) {
        // create
        if (entity.getId() == null) {
            entity.setId(++id);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setUpdatedAt(LocalDateTime.now());
        }
        // update
        else {
            var optionalEntity = findById(entity.getId());
            if (optionalEntity.isPresent()) {
                repository.remove(optionalEntity.get());
                entity.setCreatedAt(optionalEntity.get().getCreatedAt());
                entity.setUpdatedAt(LocalDateTime.now());
            }
            else return null;
        }
        repository.add(entity);
        return entity;
    }

    @Override
    public Optional<T> findById(Long id) {
        var entity = repository.stream().filter(t->(t.getId().equals(id))).findFirst();
        return entity;
    }

    @Override
    public void delete(Long id) {
        var entity = findById(id);
        entity.ifPresent(t -> repository.remove(t));
    }

    @Override
    public List<T> findAll() {
        return repository.stream().toList();
    }

    @Override
    public void deleteAll() {
        repository.clear();
        id = 0L;
    }

}
