package com.edu.ssh.dao.table;

import java.util.List;

import com.edu.ssh.entity.Table;

public interface ITableDao {
	
	
	//获取空闲餐桌
	List<Table> getTablesisFree();
	//保存餐桌信息
	void save(Table table);
	//获取所有菜品信息
	List<Table> getTables();
	//分页显示餐桌信息
	List<Table> getTableByPage(int pageNum, int pageSize);
	int getPageCount(int pageSize);
	//删除餐桌
	void delete(Table table);
	//修改餐桌信息
	Table getOneTableToUpdate(Integer id);//获取需要修改的用户信息
	void update(Table table);
	//根据条件查找餐桌
	public Long getTableCountByKey(String keyword);
	public List<Table> getTablesByKey(String keyword);
}
