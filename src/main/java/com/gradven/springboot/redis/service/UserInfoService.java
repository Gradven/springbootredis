package com.gradven.springboot.redis.service;

import com.gradven.springboot.redis.model.UserInfo;

/**
 * Created by liuhangjun on 2017/9/5.
 */
public interface UserInfoService extends CrudService<UserInfo>{
    
    UserInfo getByNickname(String nickname);
    
    UserInfo getCache(Long id);
}
