package com.yuaner.qbserver.service;

import com.yuaner.qbserver.common.api.ApiResult;
import com.yuaner.qbserver.model.dto.LoginDTO;
import com.yuaner.qbserver.model.dto.RegisterDTO;
import com.yuaner.qbserver.model.enity.User;

public interface UserService {

    ApiResult registerUser(RegisterDTO registerDTO);

    ApiResult loginUserByPassword(LoginDTO loginDTO);

    ApiResult loginUserByCode(LoginDTO loginDTO);

    ApiResult logout();

    ApiResult listUsers();
}
