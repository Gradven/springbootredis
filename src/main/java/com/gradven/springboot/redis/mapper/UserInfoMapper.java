/**
 * Copyright &copy; 2016-2022 liuhangjun All rights reserved.
 */
package com.gradven.springboot.redis.mapper;

import com.gradven.springboot.redis.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户信息Mapper接口
 * @author liuhangjun
 * @version 2017-06-15
 */
@Repository
public interface UserInfoMapper extends CrudMapper<UserInfo> {

     UserInfo getByNickname(String nickname);

}
