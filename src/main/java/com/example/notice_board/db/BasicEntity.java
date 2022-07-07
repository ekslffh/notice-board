package com.example.notice_board.db;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BasicEntity {
    Long id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
