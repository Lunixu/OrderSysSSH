package com.edu.ssh.service.dish;

import java.util.List;

import com.edu.ssh.dao.dish.DishDaoImpl;
import com.edu.ssh.entity.Dish;

public class DishServiceImpl implements IDishService {
	
	private DishDaoImpl dishDao;

	public DishDaoImpl getDishDao() {
		return dishDao;
	}

	public void setDishDao(DishDaoImpl dishDao) {
		this.dishDao = dishDao;
	}
	/*
	 *获取所有菜品的信息
	 */
	@Override
	public List<Dish> getDishes() {
		return dishDao.getDishes();
	}
	/*
	 *分页显示菜品信息 
	 */
	@Override
	public List<Dish> getDishByPage(int pageNum, int pageSize) {
		return dishDao.getDishByPage(pageNum, pageSize);
	}

	@Override
	public int getPageCount(int pageSize) {
		return dishDao.getPageCount(pageSize);
	}
	/*
	 * (添加)保存菜品信息
	 */
	@Override
	public void save(Dish dish) {
		dishDao.save(dish);
	}

	/*
	 * 删除相对应的菜品
	 */
	@Override
	public void delete(Dish dish) {
		dishDao.delete(dish);
	}
	
	/*
	 *修改菜品信息
	 *1、获取需要修改菜品的信息，显示到修改页面
	 *2、完成修改
	 */
	@Override
	public Dish getOneDishToUpdate(Integer id) {
		return dishDao.getOneDishToUpdate(id);
	}

	@Override
	public void update(Dish dish) {
		dishDao.update(dish);
	}
	
	/*
	 * 按要求查询菜品信息，
	 * 返回数据和满足条件的数据条数
	 */
	@Override
	public List<Dish> getDishByKey(String keyword) {
		return dishDao.getDishByKey(keyword);
	}

	@Override
	public Long getCountDishByKey(String keyword) {
		return dishDao.getCountDishByKey(keyword);
	}

	/*
	 * 根据Id查询菜品信息/(non-Javadoc)
	 * @see com.edu.ssh.service.dish.IDishService#getById(int)
	 */
	@Override
	public Dish getById(int id) {
		return dishDao.getById(id);
	}
}
