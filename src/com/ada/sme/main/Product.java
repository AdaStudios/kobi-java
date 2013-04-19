/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.sme.main;

/**
 *
 * @author PaDaWaN
 */


import java.io.Serializable;

public class Product implements Serializable {
	private int pId;
	private String pName;
	private String pFeature;
	private int amount;
	private double price;

	public Product(int pId, String pName, int amount,
			double price, String pFeature) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pFeature = pFeature;
		this.amount = amount;
		this.price = price;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpFeature() {
		return pFeature;
	}

	public void setpFeature(String pFeature) {
		this.pFeature = pFeature;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return pId + " " + pName + " "+ pFeature + " " + amount + " " + price + "\n";
	}





}