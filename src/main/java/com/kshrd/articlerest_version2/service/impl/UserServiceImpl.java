package com.kshrd.articlerest_version2.service.impl;

import com.kshrd.articlerest_version2.repository.UserRepository;
import com.kshrd.articlerest_version2.repository.dto.UserDto;
import com.kshrd.articlerest_version2.rest.response.Messages;
import com.kshrd.articlerest_version2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto insert(UserDto userDto) {
        boolean isInserted = userRepository.insert(userDto);
        System.out.println("Testing");
        if (isInserted)
            return userDto;
        else
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    Messages.Error.INSERT_FAILURE.getMessage());

    }

}
