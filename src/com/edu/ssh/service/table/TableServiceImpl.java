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
	 *��ȡ���в�������Ϣ
	 */
	@Override
	public List<Table> getTables() {
		return tableDao.getTables();
	}
	
	
	/*
	 *��ҳ��ʾ������Ϣ 
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
	 * (���)���������Ϣ
	 */
	@Override
	public void save(Table table) {
		tableDao.save(table);
	}
	
	
	/*
	 * ɾ�����Ӧ�Ĳ���
	 */
	@Override
	public void delete(Table table) {
		tableDao.delete(table);
	}
	
	
	/*
	 *�޸Ĳ�����Ϣ
	 *1����ȡ��Ҫ�޸Ĳ�������Ϣ����ʾ���޸�ҳ��
	 *2������޸�
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
	 * ��Ҫ���ѯ������Ϣ��
	 * �������ݺ�������������������
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
	 * ��ÿ��еĲ���/(non-Javadoc)
	 * @see com.edu.ssh.service.table.ITableService#getTablesisFree()
	 */
	@Override
	public List<Table> getTablesisFree() {
		return tableDao.getTablesisFree();
	}

}
