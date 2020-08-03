package com.amay.cont.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMqMsgDto {
    private Integer userId;
    private Integer integral;
}
