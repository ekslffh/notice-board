package com.example.notice_board.post.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostRequest {
    String title;
    String content;
}
