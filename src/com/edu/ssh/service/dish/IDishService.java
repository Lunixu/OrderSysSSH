package com.edu.ssh.service.dish;

import java.util.List;

import com.edu.ssh.entity.Dish;

public interface IDishService {
	
	//����id���Ʒ
	Dish getById(int id);
	//���棨��ӣ���Ʒ��Ϣ
	void save(Dish dish);
	//��ȡ���в�Ʒ��Ϣ
	List<Dish> getDishes();
	//��ҳ��ʾ��Ʒ��Ϣ
	List<Dish> getDishByPage(int pageNum, int pageSize);
	int getPageCount(int pageSize);
	//ɾ����Ʒ
	void delete(Dish dish);
	//�޸Ĳ�Ʒ��Ϣ
	Dish getOneDishToUpdate(Integer id);//��ȡ��Ҫ�޸ĵ��û���Ϣ
	void update(Dish dish);
	//��Ҫ���ѯ��Ӧ��Ʒ����
	List<Dish> getDishByKey(String keyword);
	Long getCountDishByKey(String keyword);

}
