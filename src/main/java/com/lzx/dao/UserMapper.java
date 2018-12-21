package com.lzx.dao;

import com.lzx.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByUser(User user);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}