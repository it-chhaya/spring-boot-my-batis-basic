package com.kshrd.articlerest_version2.service.impl;

import com.kshrd.articlerest_version2.repository.UserRepository;
import com.kshrd.articlerest_version2.repository.dto.RoleDto;
import com.kshrd.articlerest_version2.repository.dto.UserDto;
import com.kshrd.articlerest_version2.rest.response.Messages;
import com.kshrd.articlerest_version2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.selectUserByUsername(username);
    }

    @Override
    public UserDto insert(UserDto userDto) {
        try {
            userRepository.insert(userDto);
            int id = userRepository.selectIdByUserId(userDto.getUserId());
            userDto.setId(id);
            for (RoleDto role : userDto.getRoles()) {
                userRepository.createUserRoles(userDto, role);
            }
            return userDto;
        } catch (Exception e) {
            System.out.println("Error");
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    Messages.Error.INSERT_FAILURE.getMessage()
            );
        }
    }

}
