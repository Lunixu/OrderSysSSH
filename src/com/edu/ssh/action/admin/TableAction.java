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
	 * 餐桌信息分页显示
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
	 * 1、添加餐桌信息
	 * 2、添加成功后，分页显示
	 */
	public String add(){
		tableService.save(table);
		return "success";
	}
	
	/*
	 * 1、删除对应餐桌信息
	 * 2、分页显示完成后的餐桌
	 */
	public String delete(){
		tableService.delete(table);
		return "success";
	}
	
	/*
	 * 1、获取需要修改的餐桌，并显示
	 * 2、修改内容，保存
	 * 3、显示修改后的餐桌
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
	 * 1、获取查询条件
	 * 2、根据条件获取对应的值或满足条件的数据条数
	 */
	public String search(){
		Long tablecount = tableService.getTableCountByKey(keyword);
		List<Table> tables = tableService.getTablesByKey(keyword);
		ActionContext.getContext().getSession().put("counttablebykey", tablecount);
		ActionContext.getContext().getSession().put("tablesbykey", tables);
		return "search";
	}
}
