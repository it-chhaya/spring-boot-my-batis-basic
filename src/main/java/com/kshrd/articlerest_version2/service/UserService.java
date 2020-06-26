package com.kshrd.articlerest_version2.service;

import com.kshrd.articlerest_version2.repository.dto.RoleDto;
import com.kshrd.articlerest_version2.repository.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto insert(UserDto userDto);
    boolean createUserRoles(UserDto user, RoleDto roleDto);

}
