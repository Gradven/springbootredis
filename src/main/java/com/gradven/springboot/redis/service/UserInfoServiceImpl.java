package com.gradven.springboot.redis.service;

import com.gradven.springboot.redis.cache.CacheDuration;
import com.gradven.springboot.redis.mapper.UserInfoMapper;
import com.gradven.springboot.redis.model.UserInfo;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * Created by liuhangjun on 2017/9/5.
 */
@Service
@CacheDuration(duration = 60)
public class UserInfoServiceImpl extends CrudServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService  {

    @Cacheable(value = "userCache", keyGenerator = "keyGenerator", unless="#result == null")
    @Override
    public UserInfo get(Long id){
        return super.get(id);
    }
    
    @Cacheable(value = "userCache", keyGenerator = "keyGenerator", unless="#result == null")
    @Override
    public UserInfo getCache(Long id){
        return null;
    }
    
    @Cacheable(value = "userCache", key="#nickname")
    public UserInfo getByNickname(String nickname){
        return super.mapper.getByNickname(nickname);
    }
    
    @CachePut(value="userCache", key="#model.id.toString()")
    public void add(UserInfo model){
        
        mapper.insert(model);
    }
}
