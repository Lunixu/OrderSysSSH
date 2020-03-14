package com.edu.ssh.entity;

//菜品
public class Dish {
	private Integer id; // 菜品编号
	private String name; // 菜品名称
	private String description; // 菜品简述
	private String txt; // 菜品详细描述
	private String img; // 菜品图片路径
	private char isRecommended; // 菜品是否被推荐
	private Double price; // 菜品价格

	public Dish() {
	}

	public Dish(String name, String description, String txt, String img,
			char isRecommended, Double price) {
		this.name = name;
		this.description = description;
		this.txt = txt;
		this.img = img;
		this.isRecommended = isRecommended;
		this.price = price;
	}

	public Dish(Integer id, String name, String description, String txt,
			String img, char isRecommended, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.txt = txt;
		this.img = img;
		this.isRecommended = isRecommended;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public char getIsRecommended() {
		return isRecommended;
	}

	public void setIsRecommended(char isRecommended) {
		this.isRecommended = isRecommended;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", description="
				+ description + ", txt=" + txt + ", img=" + img
				+ ", isRecommended=" + isRecommended + ", price=" + price + "]";
	}

}
