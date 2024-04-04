package com.talk.comm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int boardId;
    private String title;
    private String content;
    private String name;
    private LocalDateTime createdDate;
    private int read;
    private int memberId;
}
