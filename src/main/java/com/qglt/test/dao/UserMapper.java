package com.qglt.test.dao;

import com.qglt.test.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User queryById(Integer id);

}