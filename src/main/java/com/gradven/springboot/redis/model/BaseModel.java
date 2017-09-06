package com.gradven.springboot.redis.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by liuhangjun on 2017/9/5.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = -8648114101066903117L;
    
    private Long id;
    private Date createDate;
    private Date updateDate;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    public Date getUpdateDate() {
        return updateDate;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
