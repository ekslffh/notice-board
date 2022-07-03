package com.example.noticeborder;

import java.util.List;
import java.util.Optional;

public interface RepositoryIfs<T> {
    // Create, Update
    public T save(T entity);
    // Read
    public Optional<T> get(Long id);
    // Delete
    public void delete(Long id);

    public List<T> findAll();
    public void deleteAll();
}
