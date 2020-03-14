package com.edu.ssh.action.admin;



import java.util.List;

import com.edu.ssh.entity.Table;
import com.edu.ssh.service.table.ITableService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class TableAction implements ModelDriven<Table>{
	
	private ITableService tableService;
	private Integer tableCurPage;
	private Table table;
	private String keyword;

	public ITableService getTableService() {
		return tableService;
	}

	public void setTableService(ITableService tableService) {
		this.tableService = tableService;
	}

	public Integer getTableCurPage() {
		return tableCurPage;
	}

	public void setTableCurPage(Integer tableCurPage) {
		this.tableCurPage = tableCurPage;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public Table getModel() {
		if(table==null)
			table = new Table();
		return table;
	}
	
	
	/*
	 * ������Ϣ��ҳ��ʾ
	 */
	private void showByPage(int pageSize){
		if(tableCurPage == null)
			tableCurPage = 1;
		int tablePageTotal = tableService.getPageCount(pageSize);
		ActionContext.getContext().getSession().put("tablePageTotal", tablePageTotal);
		ActionContext.getContext().getSession().put("tableCurPage", tableCurPage);
		List<Table> tables = tableService.getTableByPage(tableCurPage, pageSize);
		ActionContext.getContext().getSession().put("tables", tables);
	}
	public String list(){
		showByPage(5);
		return "list";
	}
	/*
	 * 1����Ӳ�����Ϣ
	 * 2����ӳɹ��󣬷�ҳ��ʾ
	 */
	public String add(){
		tableService.save(table);
		return "success";
	}
	
	/*
	 * 1��ɾ����Ӧ������Ϣ
	 * 2����ҳ��ʾ��ɺ�Ĳ���
	 */
	public String delete(){
		tableService.delete(table);
		return "success";
	}
	
	/*
	 * 1����ȡ��Ҫ�޸ĵĲ���������ʾ
	 * 2���޸����ݣ�����
	 * 3����ʾ�޸ĺ�Ĳ���
	 */
	public String upd(){
		Table onetable = tableService.getOneTableToUpdate(table.getId());
		ActionContext.getContext().getSession().put("onetable", onetable);
		return "upd";
	}
	
	public String update(){
		tableService.update(table);
		return "success";
	}
	
	/*
	 * 1����ȡ��ѯ����
	 * 2������������ȡ��Ӧ��ֵ��������������������
	 */
	public String search(){
		Long tablecount = tableService.getTableCountByKey(keyword);
		List<Table> tables = tableService.getTablesByKey(keyword);
		ActionContext.getContext().getSession().put("counttablebykey", tablecount);
		ActionContext.getContext().getSession().put("tablesbykey", tables);
		return "search";
	}
}
