package com.example.notice_board.post.repository;

import com.example.notice_board.db.RepositoryImpl;
import com.example.notice_board.post.entity.PostEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository extends RepositoryImpl<PostEntity> {
}
