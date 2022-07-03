package com.example.noticeborder;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BasicEntity {
    Long id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
