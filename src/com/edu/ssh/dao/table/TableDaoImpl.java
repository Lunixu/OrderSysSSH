package com.edu.ssh.dao.table;

import java.util.List;

import org.hibernate.SessionFactory;

import com.edu.ssh.entity.Table;

public class TableDaoImpl implements ITableDao {
	
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/*
	 *获取所有餐桌的信息
	 */
	@Override
	public List<Table> getTables() {
		String hql = "from Table";
		return sessionFactory.getCurrentSession()
				.createQuery(hql).list();
	}
	
	
	/*
	 *分页显示餐桌信息 
	 */
	@Override
	public List<Table> getTableByPage(int pageNum, int pageSize) {
		String hql = "from Table";
		return sessionFactory.getCurrentSession()
				.createQuery(hql).setFirstResult((pageNum-1)*pageSize)
				.setMaxResults(pageSize).list();
	}

	@Override
	public int getPageCount(int pageSize) {
		String hql = "select count(*) from Table";
		Long count = (Long)sessionFactory.getCurrentSession()
				.createQuery(hql).uniqueResult();
		return (int)((count+pageSize-1)/pageSize);
	}
	
	
	/*
	 * (添加)保存餐桌信息
	 */
	@Override
	public void save(Table table) {
		sessionFactory.getCurrentSession().save(table);
	}
	
	
	/*
	 * 删除餐桌信息
	 */
	@Override
	public void delete(Table table) {
		sessionFactory.getCurrentSession().delete(table);
	}
	
	
	/*
	 *修改餐桌信息
	 *1、获取需要修改餐桌的信息，显示到修改页面
	 *2、完成修改
	 */
	@Override
	public Table getOneTableToUpdate(Integer id) {
		String hql = "from Table where id=?";
		return (Table)sessionFactory.getCurrentSession()
				.createQuery(hql).setInteger(0, id).uniqueResult();
	}
	@Override
	public void update(Table table) {
		sessionFactory.getCurrentSession().update(table);
	}
	
	
	/*
	 * 按要求查询餐桌信息，
	 * 返回数据和满足条件的数据条数
	 */
	@Override
	public Long getTableCountByKey(String keyword) {
		String hql = "select count(*) from Table where name like ?";
		Long tableCountByKey=(Long) sessionFactory.getCurrentSession()
				.createQuery(hql).setString(0, "%"+keyword+"%").uniqueResult();
		return tableCountByKey;
	}
	@Override
	public List<Table> getTablesByKey(String keyword) {
		String hql = "from Table where name like ?";
		List<Table> tables = sessionFactory.getCurrentSession()
				.createQuery(hql).setString(0, "%"+keyword+"%").list();
		return tables;
	}
	/*
	 * 获得空闲餐桌/(non-Javadoc)
	 * @see com.edu.ssh.dao.table.ITableDao#getTablesisFree()
	 */
	@Override
	public List<Table> getTablesisFree() {
		String hql = "from Table where isFree=?";
		return sessionFactory.getCurrentSession()
				.createQuery(hql).setString(0, "是").list();
	}
}
