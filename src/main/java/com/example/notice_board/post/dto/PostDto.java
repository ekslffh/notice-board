package com.example.notice_board.post.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class PostDto {
    Long id;
    String title;
    String content;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
