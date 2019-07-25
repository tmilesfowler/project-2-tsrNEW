package com.revature.entity;

import javax.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity 
@Table(name="Car_revature")

public class Car {	
	@Id 
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="year", length=50)
	private int year;
	
	@Column(name="model", length=50)
	private String model;
	
	@Column(name="price", length=50)
	private double price;
	
	@Column(name="color", length=50)
	private String color;
	
	@Column(name="type", length=50)
	private String type;
	
	@Column(name="description", length=50)
	private String description;
	
	public Car() {}
	

	public Car(int id, int year, String model, double price, String color, String type, String description) {
		super();
		this.id = id;
		this.year = year;
		this.model = model;
		this.price = price;
		this.color = color;
		this.type = type;
		this.description = description;
	}
	
	public Car(int year, String model, double price, String color, String type, String description) {
		super();
		this.year = year;
		this.model = model;
		this.price = price;
		this.color = color;
		this.type = type;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", year=" + year + ", model=" + model + ", price=" + price + ", color=" + color
				+ ", type=" + type + ", description=" + description + "]";
	}
	
	
	
}
