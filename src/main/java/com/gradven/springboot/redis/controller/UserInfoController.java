package com.gradven.springboot.redis.controller;

import com.gradven.springboot.redis.model.UserInfo;
import com.gradven.springboot.redis.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by liuhangjun on 2017/8/24.
 */
@Api(description = "用户信息")
@RestController
@RequestMapping(value = "/user/")
public class UserInfoController extends BaseController {
    
    @Resource
    private UserInfoService userInfoService;
    

    @ApiOperation(value = "增加一个用户信息")
    @PostMapping("/add")
    public void add(@RequestBody addUserInfoEntity addUserInfoEntity) {
    
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(addUserInfoEntity, userInfo);
        userInfoService.add(userInfo);
    
    }
    
    @ApiOperation(value = "获取一个用户信息")
    @GetMapping("/{id}")
    public UserInfo get(
            @ApiParam(required = true, value = "id") @PathVariable Long id){
        
        UserInfo userInfo = userInfoService.get(id);
        return userInfo;
    }
    
    @ApiOperation(value = "只从缓存中获取")
    @GetMapping("/cache/{id}")
    public UserInfo getCache(
            @ApiParam(required = true, value = "id") @PathVariable Long id){
        
        UserInfo userInfo = userInfoService.getCache(id);
        return userInfo;
    }
    
    @ApiOperation(value = "获取一个用户信息")
    @GetMapping("/nickname/{nickname}")
    public UserInfo get(
            @ApiParam(required = true, value = "nickname") @PathVariable String nickname){
        
        UserInfo userInfo = userInfoService.getByNickname(nickname);
        return userInfo;
    }
    
    @ApiOperation(value = "删除一个用户")
    @DeleteMapping("/{id}")
    public void delete(
            @ApiParam(required = true, value = "id") @PathVariable Long id){
        userInfoService.delete(id);
        
    }
}
