package com.edu.ssh.action.admin;

import java.util.List;

import com.edu.ssh.entity.VIPCustomer;
import com.edu.ssh.service.customer.ICustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction implements ModelDriven<VIPCustomer>{
	
	private ICustomerService customerService;
	private Integer vipCurPage;
	private VIPCustomer customer;
	private String keyword;

	public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public Integer getVipCurPage() {
		return vipCurPage;
	}

	public void setVipCurPage(Integer vipCurPage) {
		this.vipCurPage = vipCurPage;
	}

	public VIPCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(VIPCustomer customer) {
		this.customer = customer;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	@Override
	public VIPCustomer getModel() {
		if(customer == null)
			customer = new VIPCustomer();
		return customer;
	}
	
	
	/*
	 * ��������Ϣ��ҳ��ʾ
	 */
	private void showByPage(int pageSize){
		if(vipCurPage == null)
			vipCurPage = 1;
		int vipPageTotal = customerService.getPageCount(pageSize);
		ActionContext.getContext().getSession().put("vipPageTotal", vipPageTotal);
		ActionContext.getContext().getSession().put("vipCurPage", vipCurPage);
		List<VIPCustomer> customers = customerService.getCustomerByPage(vipCurPage, pageSize);
		ActionContext.getContext().getSession().put("customers", customers);
	}
	
	public String list(){
		showByPage(5);
		return "list";
	}
	/*
	 * 1�������������Ϣ
	 * 2����ӳɹ��󣬷�ҳ��ʾ
	 */
	
	public String add(){
		System.out.println(customer);
		customerService.save(customer);
		return "success";
	}
	
	/*
	 * 1��ɾ����Ӧ��������Ϣ
	 * 2����ҳ��ʾ��ɺ��������
	 */
	public String delete(){
		customerService.delete(customer);
		return "success";
	}
	
	/*
	 * 1����ȡ��Ҫ�޸ĵ������ߣ�����ʾ
	 * 2���޸����ݣ�����
	 * 3����ʾ�޸ĺ��������
	 */
	public String upd(){
		VIPCustomer onecustomer = customerService.getOneCustomerToUpdate(customer.getId());
		ActionContext.getContext().getSession().put("onecustomer", onecustomer);
		return "upd";
	}
	
	public String update(){
		customerService.update(customer);
		return "success";
	}
	
	/*
	 * 1����ȡ��ѯ����
	 * 2�������콡��ȡ��Ӧ��ֵ��������������������
	 */
	public String search(){
		Long customercount = customerService.getCountCustomerByKey(keyword);
		List<VIPCustomer> customers = customerService.getCustomerByKey(keyword);
		ActionContext.getContext().getSession().put("customercountbykey", customercount);
		ActionContext.getContext().getSession().put("customersbykey", customers);
		return "search";
	}

}
