package com.kshrd.articlerest_version2.rest.restcontroller;

import com.kshrd.articlerest_version2.repository.dto.UserDto;
import com.kshrd.articlerest_version2.rest.request.UserRequestModel;
import com.kshrd.articlerest_version2.rest.response.BaseApiResponse;
import com.kshrd.articlerest_version2.rest.response.Messages;
import com.kshrd.articlerest_version2.rest.response.UserRest;
import com.kshrd.articlerest_version2.rest.utils.ApiUtils;
import com.kshrd.articlerest_version2.rest.utils.DateTimeUtils;
import com.kshrd.articlerest_version2.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class UserRestController {

    private UserServiceImpl userService;
    private ApiUtils apiUtils;
    private DateTimeUtils dateTimeUtils;

    @Autowired
    public UserRestController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Autowired
    public void setApiUtils(ApiUtils apiUtils) {
        this.apiUtils = apiUtils;
    }

    @Autowired
    public void setDateTimeUtils(DateTimeUtils dateTimeUtils) {
        this.dateTimeUtils = dateTimeUtils;
    }

    @PostMapping("/users")
    ResponseEntity<BaseApiResponse<UserRest>> insert(
            @RequestBody UserRequestModel user) {

        BaseApiResponse<UserRest> response = new BaseApiResponse<>();

        UserDto userDto = apiUtils.mapper().map(user, UserDto.class);

        userDto.setUserId("qwer-qwer-qwer-1232");

        UserDto insertedUser = userService.insert(userDto);

        UserRest userRest = apiUtils.mapper().map(insertedUser, UserRest.class);

        response.setSuccess(true);
        response.setMessage(Messages.Success.INSERT_SUCCESS.getMessage());
        response.setData(userRest);
        response.setStatus(HttpStatus.OK);
        response.setTime(dateTimeUtils.getCurrentTime());

        return ResponseEntity.ok(response);
    }

}
