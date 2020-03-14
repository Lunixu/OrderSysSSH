package com.edu.ssh.dao.dish;

import java.util.List;

import org.hibernate.SessionFactory;

import com.edu.ssh.entity.Dish;

public class DishDaoImpl implements IDishDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/*
	 *获取所有菜品的信息
	 */
	@Override
	public List<Dish> getDishes() {
		String hql = "from Dish";
		return sessionFactory.getCurrentSession()
				.createQuery(hql).list();
	}
	
	/*
	 *分页显示菜品信息 
	 */
	@Override
	public List<Dish> getDishByPage(int pageNum, int pageSize) {
		String hql = "from Dish";
		return sessionFactory.getCurrentSession()
				.createQuery(hql).setFirstResult((pageNum-1)*pageSize)
				.setMaxResults(pageSize).list();
	}

	@Override
	public int getPageCount(int pageSize) {
		String hql = "select count(*) from Dish";
		Long count = (Long)sessionFactory.getCurrentSession()
				.createQuery(hql).uniqueResult();
		return (int)((count+pageSize-1)/pageSize);
	}
	/*
	 * (添加)保存菜品信息
	 */
	@Override
	public void save(Dish dish) {
		sessionFactory.getCurrentSession().save(dish);
	}

	/*
	 * 删除菜品信息
	 */
	@Override
	public void delete(Dish dish) {
		sessionFactory.getCurrentSession().delete(dish);
	}
	
	/*
	 *修改菜品信息
	 *1、获取需要修改菜品的信息，显示到修改页面
	 *2、完成修改
	 */
	@Override
	public Dish getOneDishToUpdate(Integer id) {
		String hql = "from Dish where id=?";
		return (Dish)sessionFactory.getCurrentSession()
				.createQuery(hql).setInteger(0, id).uniqueResult();
	}

	@Override
	public void update(Dish dish) {
		sessionFactory.getCurrentSession().update(dish);
	}

	/*
	 * 按要求查询菜品信息，
	 * 返回数据和满足条件的数据条数
	 */
	@Override
	public List<Dish> getDishByKey(String keyword) {
		String hql = "from Dish where name like ?";
		List<Dish> dishs = sessionFactory.getCurrentSession()
				.createQuery(hql).setString(0, "%"+keyword+"%").list();
		return dishs;
	}

	@Override
	public Long getCountDishByKey(String keyword) {
		String hql = "select count(*) from Dish where name like ?";
		Long dishCountByKey=(Long) sessionFactory.getCurrentSession()
				.createQuery(hql).setString(0, "%"+keyword+"%").uniqueResult();
		return dishCountByKey;
	}

	/*
	 * 根据ID产讯菜品信息/(non-Javadoc)
	 * @see com.edu.ssh.dao.dish.IDishDao#getById(int)
	 */
	@Override
	public Dish getById(int id) {
		return (Dish) sessionFactory.getCurrentSession().get(Dish.class, id);
	}
	
	

}
