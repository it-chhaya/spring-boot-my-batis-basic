package com.kshrd.articlerest_version2.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String insertUserSql() {
        return new SQL(){{
            // Define SQL statement
            INSERT_INTO("users");
            VALUES("user_id", "#{userId}");
            VALUES("username", "#{username}");
            VALUES("password", "#{password}");
        }}.toString();
    }

    public String createUserRolesSql() {
        return new SQL(){{
            INSERT_INTO("users_roles");
            VALUES("user_id", "#{user.id}");
            VALUES("role_id","#{role.id}");
        }}.toString();
    }

    public String selectIdByUserIdSql(String userId) {
        return new SQL(){{
            SELECT("id");
            FROM("users");
            WHERE("user_id = '" + userId + "'");
        }}.toString();
    }

    public String loadUserByUsernameSql(String username) {
        return new SQL(){{
            SELECT("*");
            FROM("users");
            WHERE("username = #{username}");
        }}.toString();
    }

    public String selectRolesByUsernameSql(int id) {
        return new SQL(){{
            SELECT("r.id, r.name");
            FROM("roles r");
            INNER_JOIN("users_roles ur ON r.id = ur.role_id");
            WHERE("ur.user_id = '" + id + "'");
        }}.toString();
    }

}
