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
	public static String imgTxt;//用于存放菜品图片路径
	
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
	 * 菜品信息分页显示
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
	 * 1、添加菜品信息
	 * 2、添加成功后，分页显示
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
	 * 1、删除对应菜品信息
	 * 2、分页显示完成后的菜品
	 */
	public String delete(){
		dishService.delete(dish);
		return "success";
	}
	
	/*
	 * 1、获取需要修改的菜品，并显示
	 * 2、修改内容，保存
	 * 3、显示修改后的菜品
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
	 * 1、获取查询条件
	 * 2、根据天健获取对应的值或满足条件的数据条数
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
	 *导出菜品数据文件
	 *文件类型为excel
	 */
	public String export(){
		List<Dish> dishes = dishService.getDishes();
		Iterator<Dish> iter=dishes.iterator();
		
		//目标文件
		File path=new File("d:\\Dish");
		if(!path.exists())
			path.mkdir();
		File file=new File(path+"\\dishes.xls");
		
		FileOutputStream fOut=null;
		String[] title={"ID","NAME","DESCRIPTION","TXT","IMG","ISRECOMMENDED","PRICE"};
		
		try{
			//创建新的Excel工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			//创建一个工作表，并制定名字
			HSSFSheet sheet=workbook.createSheet("dishes");
			//创建1行7列的单元格
			//先创建行
			int rowNum=0;//行标
			int colNum=0;//列标
			HSSFRow row=sheet.createRow(rowNum);//创建第一行
			HSSFCell cell=null;//单元格
			for(colNum=0;colNum<7;colNum++){
				cell=row.createCell(colNum);//创建7列
				cell.setCellValue(title[colNum]); //用title数组的值给每个单元格赋值
			}
			
			rowNum=1;//从第二行开始
			colNum=0;
			
			//根据有多少行数据创建多少Excel的行
			while(iter.hasNext()){
				row=sheet.createRow(rowNum++);//循环创建行，行标每次增加1
				Dish dish=iter.next();
				colNum=0;//列标清零
				cell=row.createCell(colNum++);
				cell.setCellType(CellType.NUMERIC);//数字
				cell.setCellValue(dish.getId());
				
				cell=row.createCell(colNum++);
				cell.setCellType(CellType.STRING);//字符
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
				cell.setCellValue(dish.getIsRecommended()+"");//将char类型+""转换为字符串
				
				cell=row.createCell(colNum++);
				cell.setCellType(CellType.NUMERIC);//数字
				cell.setCellValue(dish.getPrice());
			}
			
			//新建输出文件流
			fOut = new FileOutputStream(file);
			//把响应的Excel工作簿存盘
			workbook.write(fOut);
			fOut.flush();//刷新缓存
			//关闭资源
			fOut.close();
			
			ActionContext.getContext().getSession().put("exportinfo", "菜品数据导出成功！");
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
	 *导入菜品数据文件
	 *文件类型为Excel
	 *1、判断当前行是否是空行(没有数据)
	 *2、完成导入
	 */
	private boolean isRowEmpty(HSSFRow row){
		for(int c=row.getFirstCellNum();c<row.getLastCellNum();c++){
			HSSFCell cell=row.getCell(c);
			if(cell != null && cell.getCellType() != HSSFCell.CELL_TYPE_BLANK){
				return false; //单元格中有数据，返回false
			}
		}
		return true;//空的单元格
	}
	
	public String dimport() {
		//把选择要导入的Excel数据文件上传到服务器上
		// 目标文件
		File path = new File("d://Dish");
		if (!path.exists())
			path.mkdir();
		File file = new File(path,dishfileFileName);
		
		try {
			FileUtils.copyFile(dishfile, file); //上传到服务器的d:\\Dish目录下
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream in = null;//文件输入流
		
		try{
			//创建对Excel工作簿文件的引用
			in = new FileInputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook(in);
			//创建对工作表的引用
			HSSFSheet sheet = workbook.getSheetAt(0);//取得第一个工作表
			HSSFRow row=null;
			HSSFCell cell=null;
			int rowNum=0;//行标
			int colNum=0;//列标
			
			rowNum=1;//去掉标题行从第二行开始
			
			Dish dish = new Dish();
			
			//判断当前获得的行是否为空，不为空则循环
			while(!isRowEmpty((row=sheet.getRow(rowNum)))){
				rowNum++;//增加行标
				colNum = 1; //列标清空
				
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
