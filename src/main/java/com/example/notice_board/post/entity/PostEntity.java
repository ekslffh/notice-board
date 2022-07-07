package com.example.notice_board.post.entity;

import com.example.notice_board.db.BasicEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostEntity extends BasicEntity {
    String title;
    String content;
}
