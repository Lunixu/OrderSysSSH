package com.edu.ssh.dao.table;

import java.util.List;

import com.edu.ssh.entity.Table;

public interface ITableDao {
	
	
	//��ȡ���в���
	List<Table> getTablesisFree();
	//���������Ϣ
	void save(Table table);
	//��ȡ���в�Ʒ��Ϣ
	List<Table> getTables();
	//��ҳ��ʾ������Ϣ
	List<Table> getTableByPage(int pageNum, int pageSize);
	int getPageCount(int pageSize);
	//ɾ������
	void delete(Table table);
	//�޸Ĳ�����Ϣ
	Table getOneTableToUpdate(Integer id);//��ȡ��Ҫ�޸ĵ��û���Ϣ
	void update(Table table);
	//�����������Ҳ���
	public Long getTableCountByKey(String keyword);
	public List<Table> getTablesByKey(String keyword);
}
