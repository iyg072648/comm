package com.talk.comm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDtl {
    private int roleDtlId;

    private int userId;
    private int roleId;

    private RoleMst roleMst;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
