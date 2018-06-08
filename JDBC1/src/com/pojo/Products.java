package com.pojo;
/**
 * 这种仅仅是用来封装数据的类称为bean/domain/pojo/model
 * 
 * @author pang
 *
 */
public class Products {
	
//	  `id` int(11) NOT NULL AUTO_INCREMENT,
//	  `name` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
//	  `price` double DEFAULT NULL,
//	  `category` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
//	  `pnum` int(11) DEFAULT NULL,
//	  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
//	  PRIMARY KEY (`id`)
//	) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
	
	private int id;
	private String name;
	private String price;
	private String category;
	private String pnum;
	private String description;
	
	
	
	public Products() {
		super();
	}
	public Products(int id, String name, String price, String category, String pnum, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.pnum = pnum;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", pnum="
				+ pnum + ", description=" + description + "]";
	}
	
	
	
	
	
}
