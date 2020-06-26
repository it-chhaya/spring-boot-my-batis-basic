package com.kshrd.articlerest_version2.repository;

import com.kshrd.articlerest_version2.repository.dto.RoleDto;
import com.kshrd.articlerest_version2.repository.dto.UserDto;
import com.kshrd.articlerest_version2.repository.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    @InsertProvider(type = UserProvider.class, method = "insertUserSql")
    boolean insert(UserDto userDto) throws Exception;

    @InsertProvider(type = UserProvider.class, method = "createUserRolesSql")
    boolean createUserRoles(UserDto user, RoleDto role);

    @SelectProvider(type = UserProvider.class, method = "selectIdByUserIdSql")
    int selectIdByUserId(String userId);

    @SelectProvider(type = UserProvider.class, method = "loadUserByUsernameSql")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(property = "roles", column = "id", many = @Many(select = "selectRolesByUserId"))
    })
    UserDto loadUserByUsername(String username);

    @SelectProvider(type = UserProvider.class, method = "selectIdByUserIdSql")
    List<RoleDto> selectRolesByUserId(int id);

}
