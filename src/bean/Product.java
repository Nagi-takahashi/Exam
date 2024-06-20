package bean;

import java.io.Serializable;

public class Product implements Serializable{
//	フィールド
	private int id;
	private String name;
	private int price;

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id=id;
	}

	public void setName(String name) {
		this.name=name;
	}

	public void setPrice(int price){
		this.price=price;
	}
	@Override
	public String toString() {
		return name+"<b>("+price+"円)</b>";
	}

	public int getTaxPrice(){
		return (int)(price*1.1);
	}

}
