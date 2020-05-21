package com.model2.mvc.service.domain;

import java.sql.Date;

public class Product {
	
	private int prodNo;
	private String prodName;
	private String prodDetail;
	private String manuDay;
	private int price;
	private String imgFile;
	private Date regDate;
	private String prodTranCode;
	
	public Product() { 
	}

	public int getProdNo() {
		return prodNo;
	}

	public String getProdName() {
		return prodName;
	}

	public String getProdDetail() {
		return prodDetail;
	}

	public String getManuDay() {
		return manuDay;
	}

	public int getPrice() {
		return price;
	}

	public String getimgFile() {
		return imgFile;
	}

	public Date getRegDate() {
		return regDate;
	}

	public String getProdTranCode() {
		return prodTranCode;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}

	public void setManuDay(String manuDay) {
		this.manuDay = manuDay;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setimgFile(String img_file) {
		this.imgFile = img_file;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public void setProdTranCode(String prodTranCode) {
		this.prodTranCode = prodTranCode;
	}

	@Override
	public String toString() {
		return "Product [prodNo=" + prodNo + ", prodName=" + prodName + ", prodDetail=" + prodDetail + ", manuDay="
				+ manuDay + ", price=" + price + ", imgFile=" + imgFile + ", regDate=" + regDate + ", prodTranCode="
				+ prodTranCode + "]";
	}
	
}
