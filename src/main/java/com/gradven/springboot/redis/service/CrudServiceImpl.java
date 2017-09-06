package com.gradven.springboot.redis.service;


import com.gradven.springboot.redis.mapper.CrudMapper;
import com.gradven.springboot.redis.model.BaseModel;
import com.gradven.springboot.redis.model.Paging;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author liuhangjun
 * @date 2017年2月4日
 * @param <M>
 * @param <T>
 */
public abstract class CrudServiceImpl<M extends CrudMapper<T>, T extends BaseModel> implements CrudService<T> {
	
	//@Autowired 默认按照type注入，@Resource默认按照name注入，此处类型不固定，名称是固定的，应该按照类型注入
	@Autowired
	public M mapper;
	
	/**
	 * 此方法和get(T model)为二选一进行使用
     * 建议改为使用传入model的方法
	 * @param id
	 * @return
	 */
	public T get(Long id){
		
		return mapper.get(id);
	}
    
    public T get(T model){
        return mapper.get(model);
    }
	
	public Paging<T> getPaging(T model) {
		Paging<T> paging = new Paging();
		paging.setCount(mapper.findAllCount(model));
		paging.setRows(mapper.findList(model));

		return paging;
	}
	
	public void add(T model){
		mapper.insert(model);
	}
	
	public void update(T model){
		mapper.update(model);
	}
    
    /**
     * delete(T model)为二选一进行使用
     * 建议改为使用传入model的方法
     * @param id
     * @return
     */
	public void delete(Long id){
		mapper.delete(id);
	}
	
	public void delete(T model){
		mapper.delete(model);
	}
}
