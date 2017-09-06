package com.gradven.springboot.redis.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author liuhangjun
 * @date 2017年2月2日
 * @param <T>
 */
public interface CrudMapper<T> {

	/**
	 * 获取单条数据
	 *
	 * @param id
	 * @return
	 */
	T get(@Param("id") Long id);

	/**
	 * 获取单条数据
	 *
	 * @param model
	 * @return
	 */
	T get(T model);
	
	/**
	 * 查询数据量
	 * @param model
	 * @return
	 */
	Integer findAllCount(T model);
	
	/**
	 * 分页查询数据列表
	 *
	 * @param model
	 * @return
	 */
	List<T> findList(T model);

	/**
	 * 插入数据
	 *
	 * @param model
	 * @return
	 */
	Long insert(T model);

	/**
	 * 更新数据
	 *
	 * @param model
	 * @return
	 */
	void update(T model);

	/**
	 * 删除数据
	 * 在生成mapper时根据表中是否有del_flag自动判断是物理删除还是逻辑删除
	 *
	 * @param id
	 * @see public int delete(String id)
	 * @return
	 */
	void delete(@Param("id") Long id);
	
	/**
	 * 删除数据
	 * 在生成mapper时根据表中是否有del_flag自动判断是物理删除还是逻辑删除
	 *
	 * @param model
	 * @see public int delete(String id)
	 * @return
	 */
	void delete(T model);


}
