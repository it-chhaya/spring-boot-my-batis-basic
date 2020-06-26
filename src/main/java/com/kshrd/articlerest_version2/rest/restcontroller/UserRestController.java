package com.kshrd.articlerest_version2.rest.restcontroller;

import com.kshrd.articlerest_version2.repository.dto.UserDto;
import com.kshrd.articlerest_version2.rest.request.UserRequestModel;
import com.kshrd.articlerest_version2.rest.response.BaseApiResponse;
import com.kshrd.articlerest_version2.rest.response.Messages;
import com.kshrd.articlerest_version2.rest.response.UserRest;
import com.kshrd.articlerest_version2.rest.utils.CommonUtils;
import com.kshrd.articlerest_version2.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.UUID;

@RestController
public class UserRestController {

    private UserServiceImpl userService;
    private CommonUtils commonUtils;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Autowired
    public UserRestController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCommonUtils(CommonUtils commonUtils) {
        this.commonUtils = commonUtils;
    }

    @PostMapping("/users")
    public ResponseEntity<BaseApiResponse<UserRest>> insert(
            @RequestBody UserRequestModel user
            ) {

        BaseApiResponse<UserRest> response = new BaseApiResponse<>();

        UserDto userDto = commonUtils.getMapper().map(user, UserDto.class);
        UUID uuid = UUID.randomUUID();
        userDto.setUserId(uuid.toString());
        userDto.setPassword(encoder.encode(userDto.getPassword()));

        UserDto insertedUser = userService.insert(userDto);

        UserRest userRest = commonUtils.getMapper().map(insertedUser, UserRest.class);

        response.setMessage(Messages.Success.INSERT_SUCCESS.getMessage());
        response.setData(userRest);
        response.setStatus(HttpStatus.OK);
        response.setTime(commonUtils.getCurrentTime());

        return ResponseEntity.ok(response);
    }

}
