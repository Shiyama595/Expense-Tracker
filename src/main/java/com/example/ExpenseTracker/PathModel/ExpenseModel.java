package com.example.ExpenseTracker.PathModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="expenses")
public class ExpenseModel {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
private String title;
private String type;
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
private double amount;
private String date;


}
