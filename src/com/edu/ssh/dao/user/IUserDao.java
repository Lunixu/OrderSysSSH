package com.edu.ssh.dao.user;

import java.util.List;

import com.edu.ssh.entity.User;
import com.edu.ssh.entity.UserPosition;

public interface IUserDao {
	
	//��¼��֤�û���Ϣ
	User validate(User user);
	//�����û���Ϣ
	void save(User user);
	//int validate(User user);
	//ɾ���û�
	void delete(User user);
	//�޸��û���Ϣ
	User getOneUserToUpdate(Integer id);//��ȡ��Ҫ�޸ĵ��û���Ϣ
	void update(User user);
	//��ҳ��ʾ�û���Ϣ
	List<User> getUserByPage(int pageNum, int pageSize);
	int getPageCount(int pageSize);
	//��ȡϵͳ��ɫ��Ϣ
	List<UserPosition> getAllPosition();
	UserPosition getPositionById(int id);
	//�������������û�
	public Long getCountByKey(String keyword);
	public List<User> getUsersByKey(String keyword);
}
