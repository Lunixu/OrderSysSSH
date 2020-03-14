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
	 *��ȡ���в�Ʒ����Ϣ
	 */
	@Override
	public List<Dish> getDishes() {
		return dishDao.getDishes();
	}
	/*
	 *��ҳ��ʾ��Ʒ��Ϣ 
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
	 * (���)�����Ʒ��Ϣ
	 */
	@Override
	public void save(Dish dish) {
		dishDao.save(dish);
	}

	/*
	 * ɾ�����Ӧ�Ĳ�Ʒ
	 */
	@Override
	public void delete(Dish dish) {
		dishDao.delete(dish);
	}
	
	/*
	 *�޸Ĳ�Ʒ��Ϣ
	 *1����ȡ��Ҫ�޸Ĳ�Ʒ����Ϣ����ʾ���޸�ҳ��
	 *2������޸�
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
	 * ��Ҫ���ѯ��Ʒ��Ϣ��
	 * �������ݺ�������������������
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
	 * ����Id��ѯ��Ʒ��Ϣ/(non-Javadoc)
	 * @see com.edu.ssh.service.dish.IDishService#getById(int)
	 */
	@Override
	public Dish getById(int id) {
		return dishDao.getById(id);
	}
}
