package com.example.notice_board.db;

import java.util.List;
import java.util.Optional;

public interface RepositoryIfs<T> {
    // Create, Update
    public T save(T entity);
    // Read
    public Optional<T> findById(Long id);
    // Delete
    public void delete(Long id);

    public List<T> findAll();
    public void deleteAll();
}
