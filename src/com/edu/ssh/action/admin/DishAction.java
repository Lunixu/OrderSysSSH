package com.edu.ssh.action.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.struts2.ServletActionContext;

import com.edu.ssh.entity.Dish;
import com.edu.ssh.service.dish.IDishService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class DishAction implements ModelDriven<Dish>{
	
	
	private IDishService dishService;
	private Integer dishCurPage;
	private Dish dish;
	private File dishimg;
	private File dishfile;
	private String dishfileFileName;
	private String dishimgFileName;
	private String keyword;
	private String fileText;
	public static String imgTxt;//���ڴ�Ų�ƷͼƬ·��
	
	public String getFileText() {
		return fileText;
	}

	public void setFileText(String fileText) {
		this.fileText = fileText;
	}

	public File getDishfile() {
		return dishfile;
	}

	public void setDishfile(File dishfile) {
		this.dishfile = dishfile;
	}

	public String getDishfileFileName() {
		return dishfileFileName;
	}

	public void setDishfileFileName(String dishfileFileName) {
		this.dishfileFileName = dishfileFileName;
	}

	public Integer getDishCurPage() {
		return dishCurPage;
	}

	public void setDishCurPage(Integer dishCurPage) {
		this.dishCurPage = dishCurPage;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}
	
	public File getDishimg() {
		return dishimg;
	}

	public void setDishimg(File dishimg) {
		this.dishimg = dishimg;
	}

	public String getDishimgFileName() {
		return dishimgFileName;
	}

	public void setDishimgFileName(String dishimgFileName) {
		this.dishimgFileName = dishimgFileName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public IDishService getDishService() {
		return dishService;
	}

	public void setDishService(IDishService dishService) {
		this.dishService = dishService;
	}
	
	@Override
	public Dish getModel() {
		if(dish == null)
			dish=new Dish();
		return dish;
	}
	
	/*
	 * ��Ʒ��Ϣ��ҳ��ʾ
	 */
	private void showByPage(int pageSize){
		if(dishCurPage == null)
			dishCurPage = 1;
		int dishPageTotal = dishService.getPageCount(pageSize);
		ActionContext.getContext().getSession().put("dishPageTotal", dishPageTotal);
		ActionContext.getContext().getSession().put("dishCurPage", dishCurPage);
		List<Dish> dishs = dishService.getDishByPage(dishCurPage, pageSize);
		ActionContext.getContext().getSession().put("dishs", dishs);
	}
	
	public String list(){
		showByPage(5);
		return "list";
	}
	/*
	 * 1����Ӳ�Ʒ��Ϣ
	 * 2����ӳɹ��󣬷�ҳ��ʾ
	 */
	
	public String add(){
		String path = ServletActionContext.getServletContext().getRealPath("/dishimgs");
		File file = new File(path,dishimgFileName);
		try {
			FileUtils.copyFile(dishimg, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dish.setImg("/OrderSysSSH/dishimgs/"+dishimgFileName);
		dishService.save(dish);
		return "success";
	}
	
	/*
	 * 1��ɾ����Ӧ��Ʒ��Ϣ
	 * 2����ҳ��ʾ��ɺ�Ĳ�Ʒ
	 */
	public String delete(){
		dishService.delete(dish);
		return "success";
	}
	
	/*
	 * 1����ȡ��Ҫ�޸ĵĲ�Ʒ������ʾ
	 * 2���޸����ݣ�����
	 * 3����ʾ�޸ĺ�Ĳ�Ʒ
	 */
	public String upd(){
		Dish onedish = dishService.getOneDishToUpdate(dish.getId());
		imgTxt = onedish.getImg();
		ActionContext.getContext().getSession().put("onedish", onedish);
		return "upd";
	}
	
	public String update(){
		if(fileText.endsWith(imgTxt)){
			dish.setImg(imgTxt);
		}else{
			String path = ServletActionContext.getServletContext().getRealPath("/dishimgs");
			File file = new File(path,dishimgFileName);
			try {
				FileUtils.copyFile(dishimg, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			dish.setImg("/OrderSysSSH/dishimgs/"+dishimgFileName);
		}
		dishService.update(dish);
		return "success";
	}
	
	/*
	 * 1����ȡ��ѯ����
	 * 2�������콡��ȡ��Ӧ��ֵ��������������������
	 */
	public String search(){
		Long dishcount = dishService.getCountDishByKey(keyword);
		List<Dish> dishs = dishService.getDishByKey(keyword);
		System.out.println(dishcount);
		ActionContext.getContext().getSession().put("countdishbykey", dishcount);
		ActionContext.getContext().getSession().put("dishsbykey", dishs);
		return "search";
	}
	
	/*
	 *������Ʒ�����ļ�
	 *�ļ�����Ϊexcel
	 */
	public String export(){
		List<Dish> dishes = dishService.getDishes();
		Iterator<Dish> iter=dishes.iterator();
		
		//Ŀ���ļ�
		File path=new File("d:\\Dish");
		if(!path.exists())
			path.mkdir();
		File file=new File(path+"\\dishes.xls");
		
		FileOutputStream fOut=null;
		String[] title={"ID","NAME","DESCRIPTION","TXT","IMG","ISRECOMMENDED","PRICE"};
		
		try{
			//�����µ�Excel������
			HSSFWorkbook workbook = new HSSFWorkbook();
			//����һ�����������ƶ�����
			HSSFSheet sheet=workbook.createSheet("dishes");
			//����1��7�еĵ�Ԫ��
			//�ȴ�����
			int rowNum=0;//�б�
			int colNum=0;//�б�
			HSSFRow row=sheet.createRow(rowNum);//������һ��
			HSSFCell cell=null;//��Ԫ��
			for(colNum=0;colNum<7;colNum++){
				cell=row.createCell(colNum);//����7��
				cell.setCellValue(title[colNum]); //��title�����ֵ��ÿ����Ԫ��ֵ
			}
			
			rowNum=1;//�ӵڶ��п�ʼ
			colNum=0;
			
			//�����ж��������ݴ�������Excel����
			while(iter.hasNext()){
				row=sheet.createRow(rowNum++);//ѭ�������У��б�ÿ������1
				Dish dish=iter.next();
				colNum=0;//�б�����
				cell=row.createCell(colNum++);
				cell.setCellType(CellType.NUMERIC);//����
				cell.setCellValue(dish.getId());
				
				cell=row.createCell(colNum++);
				cell.setCellType(CellType.STRING);//�ַ�
				cell.setCellValue(dish.getName());
				
				cell=row.createCell(colNum++);
				cell.setCellType(CellType.STRING);//
				cell.setCellValue(dish.getDescription());
				
				cell=row.createCell(colNum++);
				cell.setCellType(CellType.STRING);//
				cell.setCellValue(dish.getTxt());
				
				cell=row.createCell(colNum++);
				cell.setCellType(CellType.STRING);//
				cell.setCellValue(dish.getImg());
				
				cell=row.createCell(colNum++);
				cell.setCellType(CellType.STRING);//
				cell.setCellValue(dish.getIsRecommended()+"");//��char����+""ת��Ϊ�ַ���
				
				cell=row.createCell(colNum++);
				cell.setCellType(CellType.NUMERIC);//����
				cell.setCellValue(dish.getPrice());
			}
			
			//�½�����ļ���
			fOut = new FileOutputStream(file);
			//����Ӧ��Excel����������
			workbook.write(fOut);
			fOut.flush();//ˢ�»���
			//�ر���Դ
			fOut.close();
			
			ActionContext.getContext().getSession().put("exportinfo", "��Ʒ���ݵ����ɹ���");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(fOut!=null){fOut.close();}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "success";
	}
	
	/*
	 *�����Ʒ�����ļ�
	 *�ļ�����ΪExcel
	 *1���жϵ�ǰ���Ƿ��ǿ���(û������)
	 *2����ɵ���
	 */
	private boolean isRowEmpty(HSSFRow row){
		for(int c=row.getFirstCellNum();c<row.getLastCellNum();c++){
			HSSFCell cell=row.getCell(c);
			if(cell != null && cell.getCellType() != HSSFCell.CELL_TYPE_BLANK){
				return false; //��Ԫ���������ݣ�����false
			}
		}
		return true;//�յĵ�Ԫ��
	}
	
	public String dimport() {
		//��ѡ��Ҫ�����Excel�����ļ��ϴ�����������
		// Ŀ���ļ�
		File path = new File("d://Dish");
		if (!path.exists())
			path.mkdir();
		File file = new File(path,dishfileFileName);
		
		try {
			FileUtils.copyFile(dishfile, file); //�ϴ�����������d:\\DishĿ¼��
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream in = null;//�ļ�������
		
		try{
			//������Excel�������ļ�������
			in = new FileInputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook(in);
			//�����Թ����������
			HSSFSheet sheet = workbook.getSheetAt(0);//ȡ�õ�һ��������
			HSSFRow row=null;
			HSSFCell cell=null;
			int rowNum=0;//�б�
			int colNum=0;//�б�
			
			rowNum=1;//ȥ�������дӵڶ��п�ʼ
			
			Dish dish = new Dish();
			
			//�жϵ�ǰ��õ����Ƿ�Ϊ�գ���Ϊ����ѭ��
			while(!isRowEmpty((row=sheet.getRow(rowNum)))){
				rowNum++;//�����б�
				colNum = 1; //�б����
				
				cell = row.getCell(colNum++);
				cell.setCellType(CellType.STRING);
				dish.setName(cell.getStringCellValue());
				
				cell = row.getCell(colNum++);
				cell.setCellType(CellType.STRING);
				dish.setDescription(cell.getStringCellValue());
				
				cell = row.getCell(colNum++);
				cell.setCellType(CellType.STRING);
				dish.setTxt(cell.getStringCellValue());
				
				cell = row.getCell(colNum++);
				cell.setCellType(CellType.STRING);
				dish.setImg(cell.getStringCellValue());
				
				cell = row.getCell(colNum++);
				cell.setCellType(CellType.STRING);
				dish.setIsRecommended(cell.getStringCellValue().toCharArray()[0]);
				
				cell = row.getCell(colNum++);
				cell.setCellType(CellType.STRING);
				dish.setPrice(Double.parseDouble(cell.getStringCellValue()));
				
				dishService.save(dish);
			}
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "success";
	}
}
