package com.kshrd.articlerest_version2.repository;

import com.kshrd.articlerest_version2.repository.dto.RoleDto;
import com.kshrd.articlerest_version2.repository.dto.UserDto;
import com.kshrd.articlerest_version2.repository.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Repository
public interface UserRepository {

    @InsertProvider(type = UserProvider.class, method = "insertUserSql")
    boolean insert(UserDto userDto) throws PSQLException;

    @InsertProvider(type = UserProvider.class, method = "createUserRolesSql")
    boolean createUserRoles(UserDto user, RoleDto role);

    @SelectProvider(type = UserProvider.class, method = "selectIdByUserId")
    int selectIdByUserId(String userId);

    @SelectProvider(type = UserProvider.class, method = "selectUserByUsernameSql")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "id",
                    property = "roles",
            many = @Many(select = "selectRolesByUserId"))
    })
    UserDto selectUserByUsername(String username);

    @Select("select r.id, r.name from roles r\n" +
            "inner join users_roles ur on r.id = ur.role_id\n" +
            "where ur.user_id = #{id}")
    List<RoleDto> selectRolesByUserId(int id);

}
