package com.yuaner.qbserver.model.dto;

import lombok.Data;

@Data
public class UserDTO {
    Long userId;//不可修改
    String nickname;
    Integer sex;
    String introduction;
}
