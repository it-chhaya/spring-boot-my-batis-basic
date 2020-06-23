package com.kshrd.articlerest_version2.repository;

import com.kshrd.articlerest_version2.repository.dto.UserDto;
import com.kshrd.articlerest_version2.repository.provider.UserProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface UserRepository {

    @InsertProvider(type = UserProvider.class, method = "insertUserSql")
    boolean insert(UserDto userDto) throws PSQLException;

}
