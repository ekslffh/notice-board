package com.example.noticeborder.entity;

import com.example.noticeborder.BasicEntity;

import java.time.LocalDateTime;

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
