package com.kshrd.articlerest_version2.service.impl;

import com.kshrd.articlerest_version2.repository.UserRepository;
import com.kshrd.articlerest_version2.repository.dto.RoleDto;
import com.kshrd.articlerest_version2.repository.dto.UserDto;
import com.kshrd.articlerest_version2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDto userDto = userRepository.loadUserByUsername(username);

        System.out.println(userDto);

        List<RoleDto> roles = userRepository.selectRolesByUserId(1);

        System.out.println(Arrays.toString(roles.toArray()));

        return userDto;

    }

    @Override
    public UserDto insert(UserDto userDto) {
        try {
            boolean isInserted = userRepository.insert(userDto);
            if (isInserted) {
                userDto.setId(userRepository.selectIdByUserId(userDto.getUserId()));
                for (RoleDto roleDto : userDto.getRoles()) {
                    userRepository.createUserRoles(userDto, roleDto);
                }
            }
            return isInserted ? userDto : null;
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage()
            );
        }
    }

    @Override
    public boolean createUserRoles(UserDto user, RoleDto roleDto) {
        return userRepository.createUserRoles(user, roleDto);
    }

}
