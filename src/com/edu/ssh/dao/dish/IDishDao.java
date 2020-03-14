package com.edu.ssh.dao.dish;

import java.util.List;
import com.edu.ssh.entity.Dish;


public interface IDishDao {
	
	//根据id查菜品
	Dish getById(int id);
	//保存菜品
	void save(Dish dish);
	//获取所有菜品信息
	List<Dish> getDishes();
	//分页显示菜品信息
	List<Dish> getDishByPage(int pageNum, int pageSize);
	int getPageCount(int pageSize);
	//删除相对应的菜品
	void delete(Dish dish);
	//修改菜品信息
	Dish getOneDishToUpdate(Integer id);//获取需要修改的用户信息
	void update(Dish dish);
	//按要求查询相应菜品数据
	List<Dish> getDishByKey(String keyword);
	Long getCountDishByKey(String keyword);
}
