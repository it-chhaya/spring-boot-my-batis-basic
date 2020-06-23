package com.kshrd.articlerest_version2.repository;

import com.kshrd.articlerest_version2.repository.dto.UserDto;
import com.kshrd.articlerest_version2.repository.provider.UserProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    @InsertProvider(type = UserProvider.class, method = "insertUserSql")
    boolean insert(UserDto userDto);

}
