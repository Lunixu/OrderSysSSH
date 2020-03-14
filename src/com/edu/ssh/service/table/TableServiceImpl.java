package com.edu.ssh.service.table;

import java.util.List;

import com.edu.ssh.dao.table.ITableDao;
import com.edu.ssh.entity.Table;

public class TableServiceImpl implements ITableService {
	
	private ITableDao tableDao;
	
	public ITableDao getTableDao() {
		return tableDao;
	}

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	/*
	 *获取所有餐桌的信息
	 */
	@Override
	public List<Table> getTables() {
		return tableDao.getTables();
	}
	
	
	/*
	 *分页显示餐桌信息 
	 */
	@Override
	public List<Table> getTableByPage(int pageNum, int pageSize) {
		return tableDao.getTableByPage(pageNum, pageSize);
	}
	@Override
	public int getPageCount(int pageSize) {
		return tableDao.getPageCount(pageSize);
	}
	
	/*
	 * (添加)保存餐桌信息
	 */
	@Override
	public void save(Table table) {
		tableDao.save(table);
	}
	
	
	/*
	 * 删除相对应的餐桌
	 */
	@Override
	public void delete(Table table) {
		tableDao.delete(table);
	}
	
	
	/*
	 *修改餐桌信息
	 *1、获取需要修改餐桌的信息，显示到修改页面
	 *2、完成修改
	 */
	@Override
	public Table getOneTableToUpdate(Integer id) {
		return tableDao.getOneTableToUpdate(id);
	}
	@Override
	public void update(Table table) {
		tableDao.update(table);
	}
	
	
	/*
	 * 按要求查询餐桌信息，
	 * 返回数据和满足条件的数据条数
	 */
	@Override
	public Long getTableCountByKey(String keyword) {
		return tableDao.getTableCountByKey(keyword);
	}
	@Override
	public List<Table> getTablesByKey(String keyword) {
		return tableDao.getTablesByKey(keyword);
	}
	
	/*
	 * 获得空闲的餐桌/(non-Javadoc)
	 * @see com.edu.ssh.service.table.ITableService#getTablesisFree()
	 */
	@Override
	public List<Table> getTablesisFree() {
		return tableDao.getTablesisFree();
	}

}
